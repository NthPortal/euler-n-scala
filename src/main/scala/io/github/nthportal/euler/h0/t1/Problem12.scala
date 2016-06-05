package io.github.nthportal.euler
package h0.t1

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.streams
import io.github.nthportal.euler.util.maths.streams.Naturals

object Problem12 extends ProjectEulerProblem {
  override def apply(): Long = {
    val t = new TriangleNumbers()
    t.triangleNumbers
      .map(i => (i, numDivisors(i, t.naturals)))
      .find(_._2 > 500)
      .get._1
  }

  private def numDivisors(num: Long, naturals: Naturals): Int = maths.divisors(num, naturals).length

  private class TriangleNumbers {
    val naturals = streams.naturals
    val intNaturals: Stream[Int] = naturals.get.map(_.toInt)
    val triangleNumbers: Stream[Long] = intNaturals.map(i => intNaturals.take(i).map(_.toLong).sum)
  }
}
