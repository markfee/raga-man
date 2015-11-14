
/**
 * Created by mark on 08/11/15.
 */
class AnagramFinder(myword: String ) {
  var word: String = myword

  def contains(str: String) = {
    str.toSet.subsetOf(word.toSet)
  }

  def toSet() : Set[Char] = {
    return toSet(word)
  }

  def toSet(str: String) : Set[Char] = {
    return str.toSet[Char]
  }

  def getSubsets(str: String) : Set[Set[Char]] = {
    return str.toSet[Char].subsets.toSet[Set[Char]] - Set()
  }

  def getSubsets() : Set[Set[Char]] = {
    return getSubsets(word)
  }

  var allSubSets : Set[Set[Set[Char]]] = Set()
  def getAllSubSets() = {
    allSubSets = Set()
    getSubSetsWithRemainder(Set(), toSet, getSubsets)
    println("**********************************************************")
    printAllSubSets
  }

  def printAllSubSets = {
    for(subset <-allSubSets) {
      for (set <- subset) {
        for (char <- set ) {
          print(char)
        }
        print(" ")
      }
      println
    }
  }

  def getSubSetsWithRemainder(headLetterSet: Set[Char], fullLetterSet: Set[Char], remainingLetterCombinations: Set[Set[Char]]) : Boolean = {
    if (remainingLetterCombinations.size == 0) {
      return false
    }

    for(letterCombo <- remainingLetterCombinations) {
      val remainingLetters = fullLetterSet.diff(letterCombo)
      var thisSubSet : Set[Set[Char]] = Set()
      val subRemainingLetterCombination : Set[Set[Char]] = remainingLetters.subsets.toSet - Set()

      thisSubSet += headLetterSet
      thisSubSet += letterCombo
      thisSubSet += remainingLetters
      thisSubSet -= Set()
      if (headLetterSet.size + letterCombo.size + remainingLetters.size == word.size) {
        allSubSets += thisSubSet
      }

      getSubSetsWithRemainder(letterCombo, remainingLetters, subRemainingLetterCombination - Set())
    }
    return true
  }

  def getSubWords(strHead: String, strFoot: String) : String = {
    if (strHead.size < 1) {
      return strFoot + ".\n"
    }
    var newString: String = ":"
    var count: Int = 0
    for(c <- strHead) {
      count += 1
      newString = newString.concat(c + getSubWords(strHead.drop(count), ""))
    }
    return newString
  }


  def getSubsetCombinations() : Set[Set[Char]] = {
    return getSubsetCombinations(Set(), word.toSet[Char])
  }

  def getSubsetCombinations(head: Set[Char], remainder: Set[Char]) : Set[Set[Char]] = {
    println("getSubsetCombinations")
    println(head)
    println(remainder)
    println("/getSubsetCombinations")
    if (remainder.size == 0) {
      if (head.size > 0 ) {
        return Set(head)
      } else {
        return Set()
      }
    }
    var fullSet : scala.collection.mutable.Set[Set[Char]] = scala.collection.mutable.Set(head)
    for (newHead <- remainder) {
      val newSet = getSubsetCombinations(Set(newHead), remainder.diff(Set(newHead)))
      fullSet = fullSet.union(newSet)
    }
    println(fullSet.toSet)
    println("/getSubsetCombinations2")
    return fullSet.toSet
  }
/*

  def getSubsetCombinations(str: String) : Set[Set[Set[Char]]] = {
    return getSubsetCombinations(getSubsets(str))
  }

  def getSubsetCombination(subsets: Set[Char]) : Set[Set[Char]] = {
    var subsetCombination : scala.collection.mutable.Set[Set[Char]] = scala.collection.mutable.Set()
    for(char: Char <- subsets) {
      val remainder = subsets.diff(Set(char))
      subsetCombination += Set(char)
      subsetCombination += getSubsetCombination(remainder)
    }
    return subsetCombination
  }

  def getSubsetCombinations(subsets: Set[Set[Char]]) : Set[Set[Set[Char]]] = {
    var subsetCombinations : scala.collection.mutable.Set[Set[Set[Char]]] = scala.collection.mutable.Set()
    for(subset: Set[Char] <- subsets) {
      val remainder = subsets.diff(Set(subset))
      subsetCombinations += getSubsetCombinations(remainder)
    }
    return subsetCombinations.toSet
  }
*/



}