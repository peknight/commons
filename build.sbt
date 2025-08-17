com.peknight.build.sbt.commonSettings

lazy val commons = (project in file("."))
  .aggregate(
    commonsText.jvm,
    commonsText.js,
    commonsText.native,
    commonsTime.jvm,
    commonsTime.js,
    commonsText.native,
  )
  .settings(
    name := "commons",
  )

lazy val commonsText = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("commons-text"))
  .settings(
    name := "commons-text",
  )

lazy val commonsTime = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("commons-time"))
  .settings(
    name := "commons-time",
  )
