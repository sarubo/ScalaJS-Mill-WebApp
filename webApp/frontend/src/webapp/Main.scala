package webapp

import org.scalajs.dom

import scala.scalajs.js.annotation.JSExportTopLevel

@main
def main(): Unit = println("Hello world!")

@JSExportTopLevel("clickAction")
def clickAction(): Unit = dom.window.alert("you just clicked me")
