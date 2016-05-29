package io.github.nthportal.euler
package h0.t0

import io.github.nthportal.euler.util.Primes

object Problem7 extends ProjectEulerProblem {
  override def apply(): Long = Primes.primes.drop(10000).head
}
