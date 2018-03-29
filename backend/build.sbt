name := """backend"""
organization := "com.cmu.sads18.team3"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"

PlayKeys.devSettings := Seq("play.server.http.port" -> "9000")