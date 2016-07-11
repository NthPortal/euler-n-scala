package io.github.nthportal.euler
package h0.t3

import io.github.nthportal.euler.util.maths.{NumericFormat, streams}

object Problem36 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.naturals.get
      .takeWhile(_ < 1000000)
      .filter(i => NumericFormat.isPalindrome(i) && NumericFormat.isBinaryPalindrome(i))
      .sum
  }
}
