name := """LollySPlay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

// Resolver is needed only for SNAPSHOT versions
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
    "com.typesafe.play" %% "play-slick" % "1.0.1",
    "com.typesafe.play" %% "play-slick-evolutions" % "1.0.1",
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "org.slf4j" % "slf4j-nop" % "1.7.12",
    "org.xerial" % "sqlite-jdbc" % "3.8.11.2",
    "com.adrianhurt" %% "play-bootstrap" % "1.0-P24-B3-SNAPSHOT"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

fork in run := false
fork in Test := false


fork in run := true