name := "hello"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.5" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

