lazy val library = (project in file("."))
  .enablePlugins(FlakyPlugin)

resolvers += "Otrebski" at "http://otrebski.bintray.com/sbt-plugins"

name := "custom-task"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7" % "test"

