name := """backend"""
organization := "com.cmu.sads18.team3"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies += "org.avaje" % "ebean" % "2.7.3"
libraryDependencies += "javax.persistence" % "persistence-api" % "1.0.2"

PlayKeys.devSettings := Seq("play.server.http.port" -> "9000")