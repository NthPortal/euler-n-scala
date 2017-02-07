package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.{NaturalSpiral, streams}

object Problem58 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes
    NaturalSpiral.groupedCorners
      .scanLeft((1, 0)) { case ((total, prime), corners) => (total + 4, prime + corners.count(_.isPrime)) }
      .zip(streams.oddNaturals())
      .drop(1)
      .find { case ((total, prime), _) => prime.toDouble / total < 0.1 }
      .get
      ._2
  }
}
