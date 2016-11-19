package com.nthportal.euler
package h0.t3

import com.nthportal.euler.maths.{Primes, streams}

object Problem35 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes
    primes()
      .takeWhile(_ < 1000000)
      .count(i => rotations(i).forall(Primes.isPrime(_, primes)))
  }

  private def rotations(i: Long): Seq[Long] = {
    val digits = i.digits.toIndexedSeq
    val sequences = for (i <- 0 to digits.length) yield digits.slice(i, digits.length) ++ digits.slice(0, i)
    sequences.map(_.asNumber)
  }
}
