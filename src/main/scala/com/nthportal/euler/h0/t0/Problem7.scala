package com.nthportal.euler
package h0.t0

import com.nthportal.euler.maths.Primes

object Problem7 extends ProjectEulerProblem {
  override def apply(): Long = Primes.primes.drop(10000).head
}
