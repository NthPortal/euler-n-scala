package io.github.nthportal.euler
package h0.t2

import io.github.nthportal.euler.util.Math

object Problem20 extends ProjectEulerProblem {
  override def apply(): Long = {
    Math.factorial(100)
      .toString
      .toStream
      .map(_.asDigit.toLong)
      .sum
  }
}
