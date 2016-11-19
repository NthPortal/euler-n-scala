package com.nthportal.euler
package h0.t0

object Problem6 extends ProjectEulerProblem {
  private val range = 1 to 100

  override def apply(): Long = math.pow(range.sum, 2).toLong - range.map(math.pow(_, 2).toLong).sum
}
