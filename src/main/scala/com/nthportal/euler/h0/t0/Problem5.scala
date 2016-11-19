package com.nthportal.euler
package h0.t0

import com.nthportal.euler.util.maths.Primes

object Problem5 extends ProjectEulerProblem {
  override def apply(): Long = {
    (1 to 20)
      .map(Primes.primeFactors(_).toList)
      .map(_.groupBy(identity).mapValues(_.size))
      .flatMap(_.toSeq)
      .groupBy(_._1)
      .mapValues(_.map(_._2).max)
      .map(kv => math.pow(kv._1, kv._2).toLong)
      .product
  }
}
