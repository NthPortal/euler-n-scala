package com.nthportal.euler
package h0.t0

import com.nthportal.euler.util.maths.Primes

object Problem3 extends ProjectEulerProblem {
  override def apply(): Long = Primes.primeFactors(600851475143L).max
}
