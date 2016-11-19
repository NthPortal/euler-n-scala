package com.nthportal.euler
package h0.t1

import com.nthportal.euler.maths

object Problem15 extends ProjectEulerProblem {
  override def apply(): Long = maths.choose(40, 20).toLong
}
