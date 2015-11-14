import org.specs2.mock._
import org.specs2.mutable.Specification

class LexiconSpec extends Specification with Mockito {

 "Lexicon#countMatches" >> {
    "return 1 for any word count" >> {
      class MyLexicon extends Lexicon
      val lexicon = new MyLexicon
      lexicon.countMatches("Anything") must_==(1)
      lexicon.getMatches("Anything") must_===(List[String]("Anything"))
    }
  }
}
