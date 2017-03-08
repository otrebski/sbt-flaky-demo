name := "custom-task"

scalaVersion := "2.11.8"

val sampleTask1 = taskKey[Unit]("Create file sampleTask1.txt")
val sampleTask2 = taskKey[Unit]("Create file sampleTask2.txt")

resolvers += "Otrebski" at "http://otrebski.bintray.com/otrebski"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7" % "test"

lazy val library = (project in file("."))
  .settings(
    sampleTask1 := {println("creating file");new File("sampleTask1.txt").createNewFile()},
    sampleTask2 := {println("creating file");new File("sampleTask2.txt").createNewFile()}
  )
  // .settings(resolvers += "Otrebski" at "http://otrebski.bintray.com/otrebski")
  //.settings(flakyTask := Seq(sampleTask1, sampleTask2))
  .enablePlugins(FlakyPlugin)

//http://www.scala-sbt.org/0.13/docs/Bintray-For-Plugins.html
