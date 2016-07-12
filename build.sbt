organization := "io.github.nthportal"
name := "euler-scala"

version := "1.0.0-SNAPSHOT"
isSnapshot := true

scalaVersion := "2.11.8"
scalacOptions += "-target:jvm-1.8"

libraryDependencies += "org.jgrapht" % "jgrapht-core" % "0.9.2"

libraryDependencies += "junit" % "junit" % "4.12" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % Test
