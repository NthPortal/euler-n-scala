organization := "io.github.nthportal"
name := "euler-scala"

version := "1.0.0-SNAPSHOT"
isSnapshot := true

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.jgrapht" % "jgrapht-core" % "0.9.2",
  "junit" % "junit" % "4.12" % Test,
  "org.scalatest" %% "scalatest" % "2.2.6" % Test
)
