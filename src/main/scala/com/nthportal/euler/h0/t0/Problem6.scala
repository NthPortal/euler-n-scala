package com.nthportal.euler
package h0.t0

object Problem6 extends ProjectEulerProblem {
  private val range = 1 to 100

  override def apply(): Long = (range.sum ** 2) - range.map(_ ** 2).sum
}
