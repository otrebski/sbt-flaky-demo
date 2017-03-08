// adding the repo
resolvers += Resolver.url(
  "flaky",
  url("http://otrebski.bintray.com/sbt-plugins"))(
  Resolver.ivyStylePatterns
 )

addSbtPlugin("pl.otrebski" % "sbt-flaky" % "0.1")
