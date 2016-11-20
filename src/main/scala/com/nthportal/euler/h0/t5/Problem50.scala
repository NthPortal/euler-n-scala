package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.streams
import com.nthportal.euler.maths.streams.Primes

object Problem50 extends ProjectEulerProblem {
  private val max = 1000000

  override def apply(): Long = {
    implicit val primes = streams.primes

    streamsOfSums(primes().takeWhile(_ < max))
      .filter(_.nonEmpty)
      .flatten
      .maxBy(_._2)
      ._1
  }

  private def sumOfPrimes(primes: Stream[Long], prev: Long = 0): Stream[Long] = {
    if (primes.isEmpty) Stream.empty
    else {
      val next = prev + primes.head
      if (next > max) Stream.empty
      else next #:: sumOfPrimes(primes.tail, next)
    }
  }

  private def streamsOfSums(primes: Stream[Long])(implicit p: Primes): Stream[Stream[(Long, Int)]] = {
    if (primes.isEmpty) Stream.empty
    else {
      val next = sumOfPrimes(primes)
        .zipWithIndex
        .filter(_._1.isPrime)
      next #:: streamsOfSums(primes.tail)
    }
  }
}
