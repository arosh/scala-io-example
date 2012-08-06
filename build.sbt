name := "rmexe"

version := "0.1"

organization := "com.github.arosh"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-explaintypes")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.1",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.1")

// sbteclipse with source
EclipseKeys.withSource := true

// sbt-onejar
seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)
