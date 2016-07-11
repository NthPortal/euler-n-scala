package io.github.nthportal.euler
package h0.t3

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.{Primes, streams}

object Problem35 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes

    primes.get
      .takeWhile(_ < 1000000)
      .count(i => rotations(i).forall(Primes.isPrime(_, primes)))
  }

  private def rotations(i: Long): Seq[Long] = {
    val digits = maths.digitsOf(i).toIndexedSeq
    val sequences = for (i <- 0 to digits.length) yield digits.slice(i, digits.length) ++ digits.slice(0, i)
    sequences.map(maths.fromDigits)
  }
}
