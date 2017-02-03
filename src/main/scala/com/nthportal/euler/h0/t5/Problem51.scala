package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.streams

object Problem51 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes

    primes().drop(4)
      .map(_.digits.toIndexedSeq)
      .flatMap(masked)
      .map(_.filter(_.isPrime))
      .filter(_.length >= 8)
      .head
      .head
  }

  private def masked(digits: Seq[Int]): Iterable[Seq[Long]] = {
    val maskableIndices = digits.indices
      .dropRight(1)
      .filter(digits(_) <= 2)

    val maskableGroups = maskableIndices
      .groupBy(digits(_))
      .map { case (digit, indices) =>
        (digit,
          indices.toSet
            .subsets()
            .withFilter(_.nonEmpty))
      }

    for {
      (startVal, indexSets) <- maskableGroups
      indices <- indexSets
    } yield maskedAtIndices(digits, indices, startVal)
  }

  private def maskedAtIndices(digits: Seq[Int], indices: Set[Int], startVal: Int): Seq[Long] = {
    for {
      digit <- startVal to 9
    } yield digits.zipWithIndex
      .map { case (d, index) => if (index in indices) digit else d }
      .asNumber
  }
}
