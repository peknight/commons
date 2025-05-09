ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.0"

ThisBuild / organization := "com.peknight"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-language:strictEquality",
    "-Xmax-inlines:64"
  ),
)

lazy val commons = (project in file("."))
  .aggregate(
    commonsText.jvm,
    commonsText.js,
    commonsTime.jvm,
    commonsTime.js
  )
  .settings(commonSettings)
  .settings(
    name := "commons",
  )

lazy val commonsText = (crossProject(JSPlatform, JVMPlatform) in file("commons-text"))
  .settings(commonSettings)
  .settings(
    name := "commons-text",
    libraryDependencies ++= Seq(
    )
  )

lazy val commonsTime = (crossProject(JSPlatform, JVMPlatform) in file("commons-time"))
  .settings(commonSettings)
  .settings(
    name := "commons-time",
    libraryDependencies ++= Seq(
    )
  )
