import org.specs2_
class HelloWorldSpec extends Specification { def is = s2"""

  This is my first specification
    it is working                 $ok
    really working!               $ok
                                  """
}
