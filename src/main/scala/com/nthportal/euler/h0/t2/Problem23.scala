package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.streams

object Problem23 extends ProjectEulerProblem {
  private val range = (1 until 28123).toStream

  override def apply(): Long = {
    val naturals = streams.naturals

    val abundantNumbers = range
      .map(i => {
        maths.divisors(i, naturals)
          .toStream
          .filter(_ != i)
          .sum
      })
      .zip(range)
      .filter { case (sumOfDivisors, num) => num < sumOfDivisors }
      .map(_._2)
      .toSet

    range.filter(!isSumOfTwoAbundantNumbers(_, abundantNumbers)).sum
  }

  private def isSumOfTwoAbundantNumbers(num: Int, abundantNumbers: Set[Int]): Boolean = {
    abundantNumbers.exists(i => i < num && abundantNumbers.contains(num - i))
  }
}
