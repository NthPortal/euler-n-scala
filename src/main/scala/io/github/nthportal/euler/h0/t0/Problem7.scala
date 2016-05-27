package io.github.nthportal.euler
package h0.t0

object Problem7 extends ProjectEulerProblem {
  private val goal = 10001

  override def apply(): Long = {
    Primes.primes
      .drop(goal - 1)
      .head
  }
}
