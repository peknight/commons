import com.peknight.build.gav.scala.scala3

com.peknight.build.sbt.commonSettings

lazy val commons = (project in file("."))
  .settings(name := "commons")
  .aggregate(commonsText.projectRefs *)
  .aggregate(commonsTime.projectRefs *)

lazy val commonsText = (projectMatrix in file("commons-text"))
  .settings(name := "commons-text")
  .jvmPlatform(scalaVersions = Seq(scala3.version))
  .jsPlatform(scalaVersions = Seq(scala3.version))
  .nativePlatform(scalaVersions = Seq(scala3.version))

lazy val commonsTime = (projectMatrix in file("commons-time"))
  .settings(name := "commons-time")
  .jvmPlatform(scalaVersions = Seq(scala3.version))
  .jsPlatform(scalaVersions = Seq(scala3.version))
  .nativePlatform(scalaVersions = Seq(scala3.version))
