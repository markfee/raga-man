/**
 * Created by mark on 08/11/15.
 */
class AnagramFinder(myword: String ) {
  var word: String = myword

  def contains(str: String) = {
    str.toSet.subsetOf(word.toSet)
  }

  def getSubsets() : Set[Set[Char]] = {
    return myword.toSet[Char].subsets.toSet[Set[Char]]
  }
}