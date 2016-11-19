package com.nthportal.euler
package h0.t0

object Problem9 extends ProjectEulerProblem {
  private val goal = 1000
  private val capAB = (goal / 2) - 1

  override def apply(): Long = {
    {
      for {a <- 1 to capAB
           b <- 1 to capAB
           c = goal - a - b
           if (math.pow(a, 2) + math.pow(b, 2)) == math.pow(c, 2)
      } yield a * b * c
    }.head
  }
}
