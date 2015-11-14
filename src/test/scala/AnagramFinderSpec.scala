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
  }
}
