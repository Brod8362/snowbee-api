val ScalatraVersion = "2.8.2"

ThisBuild / scalaVersion := "2.13.9"
ThisBuild / organization := "pw.byakuren"

lazy val hello = (project in file("."))
  .settings(
    name := "Snowbee API",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.43.v20210629" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.scalatra" %% "scalatra-json" % "2.8.2",
      "org.json4s"   %% "json4s-jackson" % "4.0.1",
      "com.lihaoyi" %% "requests" % "0.7.0"
    ),
  )

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)
