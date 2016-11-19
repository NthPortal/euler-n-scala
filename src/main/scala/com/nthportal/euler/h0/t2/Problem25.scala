package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.streams

object Problem25 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.bigFibonacci.get
      .zip(streams.naturals.get)
      .find(_._1.toString.length >= 1000)
      .get._2
  }
}
