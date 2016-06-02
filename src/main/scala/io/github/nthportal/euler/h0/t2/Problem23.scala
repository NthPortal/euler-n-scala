package io.github.nthportal.euler
package h0.t2

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.streams

object Problem23 extends ProjectEulerProblem {
  private val range = (1 until 28123).toStream

  override def apply(): Long = {
    val naturals = streams.naturals

    val abundantNumbers = range
      .map(i => {
        (i, maths.divisors(i, naturals)
          .toStream
          .filterNot(_ == i)
          .sum
          )
      })
      .filter(t => t._1 < t._2)
      .map(_._1)
      .toSet

    range.filterNot(isSumOfTwoAbundantNumbers(_, abundantNumbers)).sum
  }

  private def isSumOfTwoAbundantNumbers(num: Int, abundantNumbers: Set[Int]): Boolean = {
    abundantNumbers.exists(i => i < num && abundantNumbers.contains(num - i))
  }
}
