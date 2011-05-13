import java.util.Random
import scala.math.sqrt

/** 
 * Creates borders between list Elements
 */
def borders[T](l: List[T]): IndexedSeq[(T, T)] = {
  for (i <- 1.to(l.length-1); j <- 0.to(l.length); k = j+i if k < l.length) yield (l(j) -> l(k))
}

class P(val x: Double, val y: Double) {
  def distance(other: P) = {
    sqrt((x-other.x)*(x-other.x) + (y - other.y)*(y - other.y))
  }
}

def run(np: Int, nr: Int) {
  val r = new Random
  var m = 0.0
  for (c <- 1.to(nr)) {
    val lp = for (i <- 1.to(np)) yield new P(r.nextDouble, r.nextDouble)
    val b = borders(lp.toList)
    val md = b.map(t => t._1.distance(t._2)).sum / b.length
    m = m + md
    println("Mean distance between " + lp.length + " points = " + md)
  }
  println("Mean distance after " + nr + " runs " + " = " + (m/nr))
}

run(10, 1000)
