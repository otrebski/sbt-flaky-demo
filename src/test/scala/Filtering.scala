import com.typesafe.scalalogging._
import org.scalatest._

import scala.collection.mutable

class Filtering extends FlatSpec with Matchers with LazyLogging {

  "A collection" should "be filtered with many filters" in {
    logger.info("Staring test")
    var list = (1 until 20000).toList.withFilter(_ => true)
    val count = scala.util.Random.nextInt(3000)
    for (i <- 1 until count) {
      list = list.withFilter(item => item != i)
    }
    list.map(identity).head shouldBe count
   }
}
