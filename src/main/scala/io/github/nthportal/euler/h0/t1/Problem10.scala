package io.github.nthportal.euler
package h0.t1

import io.github.nthportal.euler.util.maths.Primes

object Problem10 extends ProjectEulerProblem {
  override def apply(): Long = Primes.primes.takeWhile(_ < 2000000).sum
}
