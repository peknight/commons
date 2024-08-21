ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

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
    commonsString.jvm,
    commonsString.js,
    commonsBigInt.jvm,
    commonsBigInt.js,
  )
  .settings(commonSettings)
  .settings(
    name := "commons",
  )

lazy val commonsString = (crossProject(JSPlatform, JVMPlatform) in file("commons-string"))
  .settings(commonSettings)
  .settings(
    name := "commons-string",
    libraryDependencies ++= Seq(
    )
  )

lazy val commonsBigInt = (crossProject(JSPlatform, JVMPlatform) in file("commons-bigint"))
  .settings(commonSettings)
  .settings(
    name := "commons-bigint",
    libraryDependencies ++= Seq(
      "org.scodec" %%% "scodec-bits" % scodecVersion,
    )
  )

val scodecVersion = "1.2.0"
