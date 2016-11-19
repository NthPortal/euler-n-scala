package com.nthportal.euler
package h0.t1

import com.nthportal.euler.util.maths
import com.nthportal.euler.util.maths.streams
import com.nthportal.euler.util.maths.streams.Naturals

object Problem12 extends ProjectEulerProblem {
  override def apply(): Long = {
    val triangleNumbers = streams.triangleNumbers()
    val naturals = streams.naturals

    triangleNumbers
      .map(numDivisors(_, naturals))
      .zip(triangleNumbers)
      .find(_._1 > 500)
      .get._2
  }

  private def numDivisors(num: Long, naturals: Naturals): Int = maths.divisors(num, naturals).length
}
