package com.nthportal.euler
package h0.t2

object Problem24 extends ProjectEulerProblem {
  private val goal = 1000000

  override def apply(): Long = {
    maths.permutationsOf(0 to 9)
      .drop(goal - 1)
      .map(_.asNumber)
      .head
  }
}
