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
    "com.adrianhurt" %% "play-bootstrap" % "1.0-P24-B3-SNAPSHOT"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes 

fork in run := false
fork in Test := false

ivyXML := <dependencies>{xml.XML.load("../LollyJShared/pom.xml") \\ "dependencies" \\ "dependency" filter (dep => (dep \\ "groupId").text != "org.scala-lang") map (dep => <dependency org={dep \\ "groupId" text} name={dep \\ "artifactId" text} rev={dep \\ "version" text} />)}</dependencies>


fork in run := true