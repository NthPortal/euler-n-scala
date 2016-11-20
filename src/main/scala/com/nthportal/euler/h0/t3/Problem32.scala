package com.nthportal.euler
package h0.t3

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
    val product = list.slice(5, list.length).asNumber
    for {
      i <- 1 to 4
      multiplicand = list.slice(0, i).asNumber
      multiplier = list.slice(i, 5).asNumber
    } yield (multiplicand, multiplier, product)
  }
}
