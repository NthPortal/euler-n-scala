package io.github.nthportal.euler.h0.t0

object Primes {
  private val basicPrimeSearchStream = 2 #:: Stream.iterate[Long](3) { _ + 2 }

  def primeFactors(num: Long): Stream[Long] = {
    num match {
      case i if i < 0 => primeFactors(-i)
      case 0 | 1 => Stream.empty
      case n =>
        firstFactor(n, basicPrimeSearchStream) match {
          case Some(factor) => factor #:: primeFactors(n / factor)
          case None => Stream(n)
        }
    }
  }

  def primes: Stream[Long] = primesIn(basicPrimeSearchStream, Stream.empty)

  private def firstFactor(num: Long, searchStream: Stream[Long]): Option[Long] = {
    searchStream
      .takeWhile(_ <= math.sqrt(num))
      .find(num % _ == 0)
  }

  private def primesIn(toSearch: Stream[Long], prevPrimes: Stream[Long]): Stream[Long] = {
    toSearch.headOption match {
      case Some(head) =>
        firstFactor(head, prevPrimes) match {
          case Some(_) => primesIn(toSearch.tail, prevPrimes)
          case None => head #:: primesIn(toSearch.tail, prevPrimes #::: Stream(head))
        }
      case None => Stream.empty
    }
  }
}
