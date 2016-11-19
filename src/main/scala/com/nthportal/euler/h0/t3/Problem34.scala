package com.nthportal.euler
package h0.t3

import com.nthportal.euler.util.maths
import com.nthportal.euler.util.maths.NumericFormat

object Problem34 extends ProjectEulerProblem {
  override def apply(): Long = {
    val limit = findLimit()
    Stream.from(3)
      .takeWhile(_ < limit)
      .filter(i => NumericFormat.digitsOf(i).map(maths.factorial(_).toInt).sum == i)
      .sum
  }

  private def findLimit(): Int = {
    val nineFactorial = maths.factorial(9).toInt
    Stream.iterate(nineFactorial) { _ + nineFactorial }
      .zip(Stream.from(1))
      .takeWhile { case (product, count) => product.toString.length > count }
      .last
      ._1
  }
}
