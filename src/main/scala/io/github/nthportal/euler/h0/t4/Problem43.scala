package io.github.nthportal.euler
package h0.t4

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.streams.Primes
import io.github.nthportal.euler.util.maths.{NumericFormat, streams}

object Problem43 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes

    maths.permutationsOf(0 to 9)
      .filterNot(_.head == 0)
      .filter(isSubstringPrimeDivisible(_, primes))
      .map(NumericFormat.fromDigits)
      .sum
  }

  private def isSubstringPrimeDivisible(digits: Seq[Int], primes: Primes): Boolean = {
    (1 to 7)
      .map(i => (i, NumericFormat.fromDigits(digits.slice(i, i + 3))))
      .forall { case (i, num) => primes.get.drop(i - 1).head divides num }
  }
}
