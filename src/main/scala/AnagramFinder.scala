/**
 * Created by mark on 08/11/15.
 */
class AnagramFinder(myword: String ) {
  var word: String = myword

  def contains(str: String) = {
    str.toSet.subsetOf(word.toSet)
  }
}