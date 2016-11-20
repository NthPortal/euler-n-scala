package com.nthportal.euler
package h0.t3

object Problem30 extends ProjectEulerProblem {
  private val range = 2 to ((9 ** 5) * 6)

  override def apply(): Long = range.filter(i => i == sumOfDigitPowers(i)).sum

  private def sumOfDigitPowers(num: Int): Long = {
    num.digits
      .map(_ ** 5)
      .sum
  }
}
