package com.nthportal.euler
package h0.t3

import com.nthportal.euler.maths.streams
import com.nthportal.euler.maths.streams.Primes

object Problem37 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes
    primes()
      .dropWhile(_ < 10)
      .filter(isDoublyTruncatable)
      .take(11)
      .sum
  }

  private def isDoublyTruncatable(num: Long)(implicit primes: Primes): Boolean = {
    isRightTruncatable(num) && isLeftTruncatable(num)
  }

  private def isRightTruncatable(num: Long)(implicit primes: Primes): Boolean = {
    Stream.iterate(num) {_ / 10}
      .takeWhile(_ > 0)
      .forall(_.isPrime)
  }

  private def isLeftTruncatable(num: Long)(implicit primes: Primes): Boolean = {
    Stream.iterate(num.digits.tail) {_.tail}
      .takeWhile(_.nonEmpty)
      .forall(_.asNumber.isPrime)
  }
}
