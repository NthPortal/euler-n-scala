package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.NaturalSpiral

object Problem28 extends ProjectEulerProblem {
  override def apply(): Long = NaturalSpiral.diagonalValues.take(2001).sum
}
