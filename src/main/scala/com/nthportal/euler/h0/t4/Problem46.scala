package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.streams

import scala.annotation.tailrec

object Problem46 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes
    val primeStream = primes().drop(1)
    val nonPrimes = streams.oddNaturals().drop(1).filter(!_.isPrime)

    nonPrimes
      .dropWhile(conjectureHolds(_, primeStream, primeStream, streams.naturals()))
      .head
  }

  @tailrec
  private def conjectureHolds(composite: Long,
                              primesOrig: Stream[Long],
                              primes: Stream[Long],
                              naturals: Stream[Long]): Boolean = {
    val res = primes.head + 2 * (naturals.head ** 2)
    if (res == composite) true
    else if (res > composite) {
      if (primes.head == 3) false
      else conjectureHolds(composite, primesOrig, primesOrig, naturals.tail)
    }
    else conjectureHolds(composite, primesOrig, primes.tail, naturals)
  }
}
