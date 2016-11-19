package com.nthportal.euler
package h0.t1

import com.nthportal.euler.maths.Primes

object Problem10 extends ProjectEulerProblem {
  override def apply(): Long = Primes.primes.takeWhile(_ < 2000000).sum
}
