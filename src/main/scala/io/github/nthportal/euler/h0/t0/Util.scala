package io.github.nthportal.euler.h0.t0

object Util {
  private val basicPrimeSearchStream = 2 #:: Stream.iterate[Long](3){_ + 2}

  def primeFactors(num: Long): Stream[Long] = {
    num match {
      case i if i < 0 => primeFactors(-i)
      case 0 | 1 => Stream.empty
      case n =>
        firstFactor(n) match {
          case Some(factor) => factor #:: primeFactors(n / factor)
          case None => Stream(n)
        }
    }
  }

  def firstFactor(num: Long): Option[Long] = {
    basicPrimeSearchStream
      .takeWhile(_ <= math.sqrt(num))
      .find(num % _ == 0)
  }
}
