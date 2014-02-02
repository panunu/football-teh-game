// Turn this project into a Scala.js project by importing these settings
scalaJSSettings

name := "Football the game"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
    "org.scala-lang.modules.scalajs" %% "scalajs-jquery" % "0.1-SNAPSHOT"
)

// Specify additional .js file to be passed to package-js and optimize-js
unmanagedSources in (Compile, ScalaJSKeys.packageJS) += baseDirectory.value / "js" / "startup.js"
