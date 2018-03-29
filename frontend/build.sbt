name := """frontend"""
organization := "com.cmu.sads18.team3"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += ws

PlayKeys.devSettings := Seq("play.server.http.port" -> "9001")