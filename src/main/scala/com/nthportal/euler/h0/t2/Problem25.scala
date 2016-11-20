package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.streams

object Problem25 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.bigFibonacci()
      .zip(streams.naturals())
      .find(_._1.digits.length >= 1000)
      .get._2
  }
}
