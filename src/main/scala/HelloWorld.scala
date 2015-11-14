object HelloWorld {
  def main(args: Array[String]) = {
    println("Hello world")
    val subsets = new AnagramFinder("hello").getSubsets()
    subsets.foreach(println)
    println("Goodbye world")
  }
}
