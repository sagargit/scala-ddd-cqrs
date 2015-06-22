import play.PlayScala

name := "root"

version := "1.0"

scalaVersion := "2.11.2"

lazy val core = project.in(file("core"))

lazy val crm = project.in(file("crm")).dependsOn(core).aggregate(core)

lazy val web = project.in(file("web")).dependsOn(core,crm).aggregate(core,crm).enablePlugins(PlayScala)

lazy val root = project.in(file(".")).dependsOn(crm,web).aggregate(crm,web).enablePlugins(PlayScala)