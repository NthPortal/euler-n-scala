package com.nthportal.euler.maths

object Primes {
  def primes: Stream[Long] = streams.primes.get

  def isPrime(num: Long): Boolean = num > 0 && primeFactors(num).size == 1

  def isPrime(num: Long, primes: streams.Primes): Boolean = num > 0 && primeFactors(num, primes).size == 1

  def primeFactors(num: Long): Stream[Long] = primeFactors(num, basicPrimeSearchStream)

  def primeFactors(num: Long, primes: streams.Primes): Stream[Long] = primeFactors(num, primes.get)

  private def primeFactors(num: Long, searchStream: Stream[Long]): Stream[Long] = {
    num match {
      case 0 | 1 | -1 => Stream.empty
      case n => findPrimeFactors(n, searchStream)
    }
  }

  private def basicPrimeSearchStream = 2 #:: streams.oddNaturals().drop(1)

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
