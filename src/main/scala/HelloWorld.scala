object HelloWorld {
  def main(args: Array[String]) = {
    println("Hello world")
    new AnagramFinder("abcdefghi").getSubsets.foreach(println)
    var finder = new AnagramFinder("abcde")
    finder.getAllSubSets
//    new AnagramFinder("hat").getSubsetCombinations.foreach(println)
//    println(new AnagramFinder("hat").getSubWords("hat", ""))

    println("Goodbye world")
  }
}
