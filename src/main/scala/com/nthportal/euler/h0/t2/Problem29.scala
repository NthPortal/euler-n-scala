package com.nthportal.euler
package h0.t2

object Problem29 extends ProjectEulerProblem {
  private val range = 2 to 100

  override def apply(): Long = {
    for (a <- range; b <- range) yield a *** b
  }.toSet
    .size
}
