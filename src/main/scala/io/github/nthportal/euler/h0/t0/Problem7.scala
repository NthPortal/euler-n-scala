package io.github.nthportal.euler
package h0.t0

object Problem7 extends ProjectEulerProblem {
  private val goal = 10001

  override def apply(): Long = {
    primesIn(2 #:: Stream.iterate(3L){_ + 2})
      .drop(goal - 1)
      .head
  }

  private def primesIn(s: Stream[Long]): Stream[Long] = s.filter(Util.firstFactor(_).isEmpty)
}
