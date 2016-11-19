package com.nthportal.euler
package h0.t3

import com.nthportal.euler.maths.NumericFormat

object Problem32 extends ProjectEulerProblem {
  override def apply(): Long = {
    maths.permutationsOf(1 to 9)
      .flatMap(combinations)
      .filter { case (a, b, product) => a * b == product }
      .map(_._3)
      .toSet
      .sum
  }

  private def combinations(list: Seq[Int]): IndexedSeq[(Long, Long, Long)] = {
    val product = NumericFormat.fromDigits(list.slice(5, list.length))
    for {
      i <- 1 to 4
      multiplicand = NumericFormat.fromDigits(list.slice(0, i))
      multiplier = NumericFormat.fromDigits(list.slice(i, 5))
    } yield (multiplicand, multiplier, product)
  }
}
