import scalatags.Text.all.*

object Main extends cask.MainRoutes:

  @cask.get("/")
  def hello() = cask.Response(
    headers = Seq(
      "Content-Type" -> "text/html",
      "Server" -> "cask",
    ),
    data = doctype("html")(
      html(
        lang := "en",
        head(
          tag("title")("Hello from ScalaJS"),
          script(src := "/files/main.js"),
        ),
        body(
          h1("Hello :)"),
          button(onclick := "clickAction()")("click me"),
        ),
      ),
    ),
  )

  @cask.staticFiles("/files/")
  def staticFiles() =
    // serve files from ./out/webApp/frontend/fastLinkJS.dest/
    // in the root of the project
    "out/webApp/frontend/fastLinkJS.dest/"

  initialize()
