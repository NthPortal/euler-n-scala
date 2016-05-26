package io.github.nthportal.euler
package p3

object Problem3 extends ProjectEulerProblem {
  private val num = 600851475143L

  override def apply(): Long = factorsFrom(num).max

  private def factorsFrom(num: Long): Stream[Long] = firstFactor(num) match {
    case Some(factor) => factor #:: factorsFrom(num / factor)
    case None => Stream(num)
  }

  private def firstFactor(num: Long): Option[Long] = {
    primesIn {
      Stream.iterate[Long](3)(_ + 2)
        .takeWhile(_ < math.sqrt(num))
    }.find(num % _ == 0)
  }

  private def primesIn(s: Stream[Long]): Stream[Long] = s.head #:: primesIn(s.tail filter { _ % s.head != 0 })
}
