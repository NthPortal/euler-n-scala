package com.nthportal.euler
package h0.t0

import com.nthportal.euler.maths.streams

object Problem2 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.fibonacci.get
      .takeWhile(_ < 4000000)
      .filter(_ % 2 == 0)
      .sum
  }
}
