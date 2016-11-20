package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.streams
import com.nthportal.euler.maths.streams.Primes

object Problem43 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes

    optimizedPermutations
      .filterNot(_.head == 0)
      .filter(isSubstringPrimeDivisible(_, primes))
      .map(_.asNumber)
      .sum
  }

  /**
    * The 6th digit must be `5` because `d4 d5 d6` must be divisible by 5.
    * It cannot be a `0` because `d6 d7 d8` must be divisible by `11`, `d7`
    * and `d8` must be different, and if `d6` was `0`, then `d7 d8` would be
    * a 2-digit number, and could not be divisible by `11`.
    */
  private def optimizedPermutations: Stream[Seq[Int]] = {
    maths.permutationsOf((0 to 4) ++: (6 to 9))
      .map(seq => seq.slice(0, 5) ++: 5 +: seq.slice(5, 10))
  }

  private def isSubstringPrimeDivisible(digits: Seq[Int], primes: Primes): Boolean = {
    (1 to 7)
      .map(i => (i, digits.slice(i, i + 3).asNumber))
      .forall { case (i, num) => primes.get.drop(i - 1).head divides num }
  }
}
