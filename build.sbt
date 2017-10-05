lazy val library = (project in file("."))
  .enablePlugins(FlakyPlugin)

resolvers += "Otrebski" at "http://otrebski.bintray.com/sbt-plugins"

name := "sbt-flaky-demo"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7" % "test"

libraryDependencies += "junit" % "junit" % "4.12" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

flakyLogLevelInTask := Level.Error

flakySlackHook := Some("https://hooks.slack.com/services/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")

flakyHistoryDir := Some(new File("history"))

flakyHtmlReportUrl := Some("http://localhost:63342/sbt-flaky-demo/library/target/flaky-test-reports-html/")

flakySlackDetailedReport := true
