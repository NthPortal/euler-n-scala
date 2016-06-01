package io.github.nthportal.euler.util.maths

import io.github.nthportal.euler.util.maths.streams.Primes

object Primes {
  def primes: Stream[Long] = streams.primes.get

  def primeFactors(num: Long): Stream[Long] = primeFactors(num, basicPrimeSearchStream)

  def primeFactors(num: Long, primes: Primes): Stream[Long] = primeFactors(num, primes.get)

  private def primeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    num match {
      case 0 | 1 | -1 => Stream.empty
      case n => findPrimeFactors(n, searchStream)
    }
  }

  private[maths] def oddNumbers = Stream.iterate[Long](3) { _ + 2 }

  private def basicPrimeSearchStream = 2 #:: oddNumbers

  private def findPrimeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    firstFactor(num, searchStream) match {
      case Some(factor) => factor #:: findPrimeFactors(num / factor, searchStream)
      case None => Stream(num)
    }
  }

  private[maths] def firstFactor(num: Long, searchStream: Stream[Long]): Option[Long] = {
    searchStream
      .takeWhile(i => i * i <= num)
      .find(num % _ == 0)
  }
}
