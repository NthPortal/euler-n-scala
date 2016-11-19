package com.nthportal.euler
package h0.t0

object Problem1 extends ProjectEulerProblem {
  override def apply(): Long = (1 to 999).filter(i => i % 3 == 0 || i % 5 == 0).sum
}
