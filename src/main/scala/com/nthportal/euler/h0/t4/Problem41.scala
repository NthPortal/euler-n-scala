package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.streams

object Problem41 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes

    {
      for {
        max <- 2 to 9
        digits = 1 to max
        if !digitSetNonPrime(digits)
        num <- maths.permutationsOf(1 to max)
          .filterNot(permutationNonPrime)
          .map(_.asNumber)
        if num.isPrime
      } yield num
    }.max
  }

  private def digitSetNonPrime(digits: Seq[Int]): Boolean = digits.sum % 3 == 0

  private def permutationNonPrime(seq: Seq[Int]): Boolean = seq.last.isEven || seq.last == 5
}
