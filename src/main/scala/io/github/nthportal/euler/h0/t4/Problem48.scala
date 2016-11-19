package io.github.nthportal.euler
package h0.t4

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.{NumericFormat, streams}

import scala.annotation.tailrec

object Problem48 extends ProjectEulerProblem {
  override def apply(): Long = {
    val sum = streams.naturals().take(1000)
      .map(n => maths.bigPow(n, n))
      .sum

    NumericFormat.fromDigits(lastNDigits(10, sum))
  }

  @tailrec
  def lastNDigits(n: Int, num: BigInt, prev: List[Int] = Nil): Seq[Int] = {
    if (n <= 0) prev
    else lastNDigits(n -1, num / 10, (num % 10).toInt :: prev)
  }
}
