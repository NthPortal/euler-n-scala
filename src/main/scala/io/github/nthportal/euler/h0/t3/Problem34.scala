package io.github.nthportal.euler
package h0.t3

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.NumericFormat

object Problem34 extends ProjectEulerProblem {
  override def apply(): Long = {
    val limit = findLimit()
    Stream.from(3)
      .takeWhile(_ < limit)
      .filter(i => NumericFormat.digitsOf(i).map(maths.factorial(_).toInt).sum == i)
      .sum
  }

  private def findLimit(): Int = {
    val nineFactorial = maths.factorial(9).toInt

    var digits = 1
    var result = nineFactorial

    while (result.toString.length > digits) {
      digits += 1
      result = nineFactorial * digits
    }

    digits * nineFactorial
  }
}
