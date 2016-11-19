package com.nthportal.euler
package h0.t2

import com.nthportal.euler.util.maths

object Problem29 extends ProjectEulerProblem {
  private val range = 2 to 100

  override def apply(): Long = {
    {
      for { a <- range
            b <- range
      } yield maths.bigPow(a, b)
    }.toSet
      .size
  }
}
