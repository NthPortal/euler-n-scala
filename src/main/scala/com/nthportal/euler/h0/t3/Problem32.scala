package com.nthportal.euler
package h0.t3

import com.nthportal.euler.maths

object Problem32 extends ProjectEulerProblem {
  override def apply(): Long = {
    maths.permutationsOf(1 to 9)
      .flatMap(combinations)
      .filter { case (a, b, product) => a * b == product }
      .map(_._3)
      .toSet
      .sum
  }

  private def combinations(list: Seq[Int]): IndexedSeq[(Int, Int, Int)] = {
    val product = intFromList(list.slice(5, list.length))
    for {i <- 1 to 4
         multiplicand = intFromList(list.slice(0, i))
         multiplier = intFromList(list.slice(i, 5))
    } yield (multiplicand, multiplier, product)
  }

  private def intFromList(list: Seq[Int]): Int = list.fold(0) { _ * 10 + _ }
}
