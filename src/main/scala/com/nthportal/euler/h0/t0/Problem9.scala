package com.nthportal.euler
package h0.t0

object Problem9 extends ProjectEulerProblem {
  private val goal = 1000
  private val capAB = (goal / 2) - 1

  override def apply(): Long = {
    for {
      a <- 1 to capAB
      b <- 1 to capAB
      c = goal - a - b
      if a * a + b * b == c * c
    } yield a * b * c
  }.head
}
