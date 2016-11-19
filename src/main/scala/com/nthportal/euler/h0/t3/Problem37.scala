package com.nthportal.euler
package h0.t3

import com.nthportal.euler.util.maths.streams.Primes
import com.nthportal.euler.util.maths.{NumericFormat, Primes, streams}

object Problem37 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes
    primes.get
      .dropWhile(_ < 10)
      .filter(isDoublyTruncatable(_, primes))
      .take(11)
      .sum
  }

  private def isDoublyTruncatable(num: Long, primes: Primes): Boolean = {
    isRightTruncatable(num, primes) && isLeftTruncatable(num, primes)
  }

  private def isRightTruncatable(num: Long, primes: Primes): Boolean = {
    Stream.iterate(num) { _ / 10 }
      .takeWhile(_ > 0)
      .forall(Primes.isPrime(_, primes))
  }

  private def isLeftTruncatable(num: Long, primes: Primes): Boolean = {
    Stream.iterate(NumericFormat.digitsOf(num).tail) { _.tail }
      .takeWhile(_.nonEmpty)
      .forall(digits => Primes.isPrime(NumericFormat.fromDigits(digits), primes))
  }
}
