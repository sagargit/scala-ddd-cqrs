name := "web"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % "0.7.3",
  jdbc,
  cache,
  ws
)