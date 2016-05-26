package io.github.nthportal.euler
package h0.t0

object Problem3 extends ProjectEulerProblem {
  private val num = 600851475143L

  override def apply(): Long = Util.primeFactors(num).max
}
