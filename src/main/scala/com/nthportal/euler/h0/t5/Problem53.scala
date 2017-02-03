package com.nthportal.euler
package h0.t5

object Problem53 extends ProjectEulerProblem {
  override def apply(): Long = {
    for {
      n <- 1 to 100
      r <- 1 to n
      res = n choose r
      if res > 1000000
    } yield Unit
  }.size
}
