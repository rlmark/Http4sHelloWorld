name := "Http4sHelloWorld"

version := "0.1"

scalaVersion := "2.12.5"

scalacOptions ++= Seq("-Ypartial-unification")

val http4sVersion = "0.18.5"

libraryDependencies ++= Seq(
  "org.http4s"  %% "http4s-core"    % http4sVersion,
  "org.http4s"  %% "http4s-circe"   % http4sVersion,
  "org.http4s"  %% "http4s-dsl"     % http4sVersion,
  "org.http4s"  %% "http4s-blaze-server"    % http4sVersion,
  "io.monix"    %% "monix"          % "3.0.0-RC1"
)