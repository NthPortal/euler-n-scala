package com.nthportal.euler
package h0.t0

import com.nthportal.euler.maths.streams

object Problem2 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.fibonacci()
      .takeWhile(_ < 4000000)
      .filter(2 divides _)
      .sum
  }
}
