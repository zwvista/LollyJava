package build

import sbt._
import Keys._
import Tests._

/**
 * This is a simple sbt setup generating Slick code from the given
 * database before compiling the projects code.
 */
object myBuild extends Build {
  val slickVersion = "3.0.1"

  lazy val mainProject = Project(
    id="main",
    base=file("."),
    settings = Project.defaultSettings ++ Seq(
      scalaVersion := "2.11.6",
      libraryDependencies ++= List(
        "com.typesafe.slick" %% "slick" % slickVersion,
        "com.typesafe.slick" %% "slick-codegen" % slickVersion,
        "org.slf4j" % "slf4j-nop" % "1.7.12",
        "org.xerial" % "sqlite-jdbc" % "3.8.11.2"
      ),
      slick <<= slickCodeGenTask, // register manual sbt command
      sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use
    )
  )

  // code generation task
  lazy val slick = TaskKey[Seq[File]]("gen-tables")
  lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
    val outputDir = (dir / "slick").getPath
    val url = "jdbc:sqlite:/Users/zwvista/Documents/Programs/Lolly/Lolly.db"
    val jdbcDriver = "org.sqlite.JDBC"
    val slickDriver = "slick.driver.SQLiteDriver"
    val pkg = "demo"
    toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg), s.log))
    val fname = outputDir + "/demo/Tables.scala"
    Seq(file(fname))
  }
}
