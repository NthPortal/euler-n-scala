package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths

object Problem20 extends ProjectEulerProblem {
  override def apply(): Long = {
    maths.factorial(100)
      .toString
      .toStream
      .map(_.asDigit.toLong)
      .sum
  }
}
