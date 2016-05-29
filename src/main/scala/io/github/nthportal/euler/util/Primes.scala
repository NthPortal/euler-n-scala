package io.github.nthportal.euler.util

private class Primes {
  import Primes._
  private val ps = oddNumbers.filter(firstFactor(_, ps).isEmpty)
  val stream: Stream[Long] = 2 #:: ps
}

object Primes {
  def primes: Stream[Long] = new Primes().stream

  def primeFactors(num: Long): Stream[Long] = findPrimeFactors(num, basicPrimeSearchStream)

  private def oddNumbers = Stream.iterate[Long](3) { _ + 2 }

  private def basicPrimeSearchStream = 2 #:: oddNumbers

  private def findPrimeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    num match {
      case 0 | 1 | -1 => Stream.empty
      case n =>
        firstFactor(n, searchStream) match {
          case Some(factor) => factor #:: findPrimeFactors(n / factor, searchStream)
          case None => Stream(n)
        }
    }
  }

  private def firstFactor(num: Long, searchStream: Stream[Long]): Option[Long] = {
    searchStream
      .takeWhile(i => i * i <= num)
      .find(num % _ == 0)
  }
}
