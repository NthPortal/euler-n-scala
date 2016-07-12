package io.github.nthportal.euler
package h0.t3

import io.github.nthportal.euler.util.maths

object Problem32 extends ProjectEulerProblem {
  override def apply(): Long = {
    maths.permutationsOf((1 to 9).toList)
      .flatMap(combinations)
      .filter(t => t._1 * t._2 == t._3)
      .map(_._3)
      .toSet
      .sum
  }

  private def combinations(list: List[Int]): IndexedSeq[(Int, Int, Int)] = {
    val product = intFromList(list.slice(5, list.length))
    for {i <- 1 to 4
         multiplicand = intFromList(list.slice(0, i))
         multiplier = intFromList(list.slice(i, 5))
    } yield (multiplicand, multiplier, product)
  }

  private def intFromList(list: List[Int]): Int = list.fold(0) { _ * 10 + _ }
}
