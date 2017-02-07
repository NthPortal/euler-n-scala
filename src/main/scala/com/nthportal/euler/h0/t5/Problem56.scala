package com.nthportal.euler
package h0.t5

object Problem56 extends ProjectEulerProblem {
  override def apply(): Long = {
    for {
      a <- 1 to 100
      b <- 1 to 100
    } yield (a *** b).digits.sum
  }.max
}
