organization := "com.nthportal"
name := "euler-scala"

version := "1.0.0-SNAPSHOT"
isSnapshot := true

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.jgrapht" % "jgrapht-core" % "0.9.2",
  "org.scalatest" %% "scalatest" % "3.0.+" % Test
)
