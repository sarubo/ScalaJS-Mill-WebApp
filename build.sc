import mill._
import mill.scalajslib.ScalaJSModule
import mill.scalalib._

val projectScalaVersion = "3.3.1"
val projectScalacOptions = Seq("-encoding", "utf-8", "-deprecation", "-feature")

object webApp extends JavaModule {

  object frontend extends ScalaJSModule {
    def scalaVersion = projectScalaVersion
    def scalaJSVersion = "1.15.0"
    def scalacOptions = projectScalacOptions
    def ivyDeps = Agg(
      ivy"org.scala-js::scalajs-dom::2.8.0",
    )
  }

  object backend extends ScalaModule {
    def scalaVersion = projectScalaVersion
    def scalacOptions = projectScalacOptions
    def ivyDeps = Agg(
      ivy"com.lihaoyi::cask:0.9.2",
      ivy"com.lihaoyi::scalatags:0.12.0",
    )
    def compile = T {
      frontend.fastLinkJS()
      super.compile()
    }
  }
}
