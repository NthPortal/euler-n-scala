package io.github.nthportal.euler
package h0.t1

import io.github.nthportal.euler.util.Math

object Problem15 extends ProjectEulerProblem {
  override def apply(): Long = Math.choose(40, 20).toLong
}
