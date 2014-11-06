object FileMatcher {

    private def filesHere = (new java.io.File(".")).listFiles

    def filesMatching(matcher: (String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      println(file)
    }

    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))

    def filesContaining(query: String) =
      filesMatching(_.contains(query))
}


FileMatcher.filesEnding(".scala")
println()
FileMatcher.filesContaining("sqrt")

