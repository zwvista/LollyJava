name := """LollyJPlay"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

// Resolver is needed only for SNAPSHOT versions
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
    javaJdbc,
    cache,
    javaWs,
    "org.hibernate" % "hibernate-core" % "4.3.9.Final",
    "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final",
    "org.springframework.data" % "spring-data-jpa" % "1.9.1.RELEASE",
    "org.springframework" % "spring-context" % "4.1.8.RELEASE",
    "org.springframework" % "spring-orm" % "4.1.8.RELEASE",
    "org.springframework" % "spring-jdbc" % "4.1.8.RELEASE",
    "org.springframework" % "spring-tx" % "4.1.8.RELEASE",
    "org.xerial" % "sqlite-jdbc" % "3.8.11.2",
    "com.adrianhurt" %% "play-bootstrap" % "1.0-P24-B3-SNAPSHOT"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes 

fork in run := true
