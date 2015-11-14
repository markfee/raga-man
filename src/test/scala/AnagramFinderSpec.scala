import org.specs2.mock._
import org.specs2.mutable.Specification

class AnagramFinderSpec extends Specification with Mockito {
  "AnagramFinder" should {
    "be instantiable" in {
      new AnagramFinder("hello") must beAnInstanceOf[AnagramFinder]
    }
    "I can check that a word is entirely contained within another word" in {
      new AnagramFinder("hello").contains("hell") must be_==(true)
      new AnagramFinder("hello").contains("help") must be_==(false)
      new AnagramFinder("hello").contains("leo") must be_==(true)
    }
    "I can get all subsets of a given word" in {
      val subset_a: Set[Set[Char]] = new AnagramFinder("at").getSubsets
      subset_a.size must be_==(4)
      Set().subsetOf(subset_a) must be_==(true)
      Set(Set('a')).subsetOf(subset_a) must be_==(true)
      Set(Set('t')).subsetOf(subset_a) must be_==(true)
      Set(Set('a', 't')).subsetOf(subset_a) must be_==(true)
      Set(Set('b', 't')).subsetOf(subset_a) must be_==(false)
    }

  }

}
