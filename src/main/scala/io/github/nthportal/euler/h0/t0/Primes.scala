package io.github.nthportal.euler.h0.t0

object Primes {
  def primes: Stream[Long] = 2 #:: primesIn(oddNumbers, Stream.empty)

  def primeFactors(num: Long): Stream[Long] = findPrimeFactors(num, basicPrimeSearchStream)

  private def findPrimeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    num match {
      case i if i < 0 => findPrimeFactors(-i, searchStream)
      case 0 | 1 => Stream.empty
      case n =>
        firstFactor(n, searchStream) match {
          case Some(factor) => factor #:: findPrimeFactors(n / factor, searchStream)
          case None => Stream(n)
        }
    }
  }

  private def oddNumbers = Stream.iterate[Long](3) { _ + 2 }

  private def basicPrimeSearchStream = 2 #:: oddNumbers

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
