package com.nthportal.euler
package h0.t2

object Problem20 extends ProjectEulerProblem {
  override def apply(): Long = {
    maths.factorial(100).digits
      .toStream
      .map(_.toLong)
      .sum
  }
}
