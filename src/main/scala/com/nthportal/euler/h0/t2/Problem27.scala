package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.{Primes, streams}

object Problem27 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes
    val bPrimes = primes.get.takeWhile(_ < 1000)

    (-999 to 999).flatMap(a =>
      bPrimes.map(b =>
        (a * b, {
          Stream.iterate(0){_ + 1}
            .map(n => n * n + a * n + b)
            .takeWhile(Primes.isPrime(_, primes))
            .length
        })
      ))
      .maxBy(_._2)
      ._1
  }
}
