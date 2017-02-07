package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.BigFraction

object Problem57 extends ProjectEulerProblem {
  override def apply(): Long = {
    val ops = implicitly[Fractional[BigFraction]]
    import ops.mkNumericOps

    val half = BigFraction(1, 2)
    val one = BigFraction(1, 1)
    val two = BigFraction(2, 1)

    Stream.iterate(half) { f => one / (two + f) }
      .map(_ + one)
      .map(f => f.numerator.digits.length - f.denominator.digits.length)
      .take(1000)
      .count(_ > 0)
  }
}
