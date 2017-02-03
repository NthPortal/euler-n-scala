package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.streams

object Problem52 extends ProjectEulerProblem {
  override def apply(): Long = {
    streams.naturals()
      .map { i => (i,
          1 to 6 map {_ * i}
        map {_.digits.sorted.asNumber}
        groupBy identity
      )}
      .filter(_._2.size == 1)
      .map(_._1)
      .head
  }
}
