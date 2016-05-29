package io.github.nthportal.euler.util

private class Primes {
  import Primes._
  private val ps: Stream[Long] = oddNumbers.filter(firstFactor(_, ps).isEmpty)
  val stream = 2 #:: ps
}

object Primes {
  def primes: Stream[Long] = new Primes().stream

  def primeFactors(num: Long): Stream[Long] = {
    num match {
      case 0 | 1 | -1 => Stream.empty
      case n => findPrimeFactors(n, basicPrimeSearchStream)
    }
  }

  private def oddNumbers = Stream.iterate[Long](3) { _ + 2 }

  private def basicPrimeSearchStream = 2 #:: oddNumbers

  private def findPrimeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    firstFactor(num, searchStream) match {
      case Some(factor) => factor #:: findPrimeFactors(num / factor, searchStream)
      case None => Stream(num)
    }
  }

  private def firstFactor(num: Long, searchStream: Stream[Long]): Option[Long] = {
    searchStream
      .takeWhile(i => i * i <= num)
      .find(num % _ == 0)
  }
}
