package io.github.nthportal.euler
package h0.t2

import scala.annotation.tailrec
import scala.collection.mutable

object Problem26 extends ProjectEulerProblem {
  override def apply(): Long = {
    (1 until 1000)
      .map(i => (i, longDivide(1, i)))
      .maxBy(_._2.repeating.length)
      ._1
  }

  private def longDivide(dividend: Int, divisor: Int): DecimalNumber = {
    val whole = dividend / divisor
    val (nonRepeating, repeating) = doLongDivide(dividend * 10, divisor, 0, StringBuilder.newBuilder, mutable.HashMap())
    DecimalNumber(whole, nonRepeating, repeating)
  }

  @tailrec
  private def doLongDivide(dividend: Int,
                           divisor: Int,
                           index: Int,
                           currentSolution: StringBuilder,
                           ops: mutable.HashMap[(Int, Int), Int]): (String, String) = {
    val op = (dividend, divisor)

    if (dividend == 0) {
      (currentSolution.toString(), "")
    } else if (ops contains op) {
      val repeatIndex = ops.get(op).get
      val solution = currentSolution.toString()
      (solution.substring(0, repeatIndex), solution.substring(repeatIndex))
    } else {
      ops += (op -> index)
      currentSolution.append(dividend / divisor)
      doLongDivide(dividend % divisor * 10, divisor, index + 1, currentSolution, ops)
    }
  }

  private case class DecimalNumber(whole: Int, nonRepeating: String, repeating: String) {
    override def toString: String = whole + "." + nonRepeating + { if (repeating.isEmpty) "" else "(" + repeating +
      ")" }
  }

}
