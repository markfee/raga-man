import org.specs2.Specification

class AnagramFinderSpec extends Specification { def is = s2"""
  I can get an instance of an AnagramFinder
    valid instance          $anagramFinder1
    should contain the word that we are looking for anagrams of $hasword

  I can check that a word is entirely contained within another word
    hell is contained in hello $hello_contains_hell
    help is not contained in hello  $hello_does_not_contains_help
  """
  def anagramFinder1 = new AnagramFinder("hello") must beAnInstanceOf[AnagramFinder]
  def hasword = new AnagramFinder("hello").word must be_==("hello")
  def hello_contains_hell = new AnagramFinder("hello").contains("hell") must be_==(true)
  def hello_does_not_contains_help = new AnagramFinder("hello").contains("help") must be_==(false)
}
