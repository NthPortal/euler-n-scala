package io.github.nthportal.euler
package h0.t1

object Problem14 extends ProjectEulerProblem {
  private val range = 1 to 1000000

  override def apply(): Long = {
    range.toStream
      .map(collatzStream(_).length)
      .zip(range)
      .maxBy(_._1)._2
  }

  private def collatzStream(num: Long): Stream[Long] = {
    num match {
      case 1 => Stream.empty
      case n if n % 2 == 0 => n #:: collatzStream(n / 2)
      case n => n #:: collatzStream(3 * n + 1)
    }
  }
}
