package com.nthportal.euler
package h0.t1

object Problem16 extends ProjectEulerProblem {
  override def apply(): Long = {
    (BigInt(1) << 1000).digits
      .toStream
      .map(_.toLong)
      .sum
  }
}
