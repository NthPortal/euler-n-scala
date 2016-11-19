package com.nthportal.euler
package h0.t3

import com.nthportal.euler.maths.{NumericFormat, streams}

object Problem36 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.naturals.get
      .takeWhile(_ < 1000000)
      .filter(i => NumericFormat.isPalindrome(i) && NumericFormat.isBinaryPalindrome(i))
      .sum
  }
}
