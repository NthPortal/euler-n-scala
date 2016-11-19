package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.{NumericFormat, Primes, streams}

object Problem49 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes
    val const = 3330
    val const2 = 2 * const

    primes()
      .dropWhile(_ < 1000)
      .takeWhile(_ < 10000 - const2)
      .filter(_ != 1487)
      .map(n => List(n, n + const, n + const2))
      .filter(_.forall(Primes.isPrime(_, primes)))
      .map(_.map(NumericFormat.digitsOf))
      .filter(_.map(_.sorted).toSet.size == 1)
      .map(_.reduce(_ ::: _))
      .map(NumericFormat.fromDigits)
      .head
  }
}
