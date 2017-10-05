import org.scalatest._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

class Filtering extends FlatSpec with Matchers {

  "A collection" should "be filtered with many filters" in {
    var list = (1 until 20).toList.withFilter(_ => true)
    val count = scala.util.Random.nextInt(5000)
    for (i <- 1 until count) {
      list = list.withFilter(item => item != i)
    }
    val f: Future[Int] = Future {
      list.map(identity).head
    }

//    Await.result(f, 500 millis) shouldBe count
   }
}
