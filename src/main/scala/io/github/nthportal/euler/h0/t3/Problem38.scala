package io.github.nthportal.euler
package h0.t3

import io.github.nthportal.euler.util.maths.streams

import scala.annotation.tailrec

object Problem38 extends ProjectEulerProblem {
  private val maxLength = 9
  private val digits = '1' to '9'

  override def apply(): Long = {
    streams.naturals.get
      .takeWhile(_ < 10 ** 5)
      .map(concatenatedProduct)
      .filter(_.length == maxLength)
      .filter(isPandigital)
      .map(_.toLong)
      .max
  }

  private def concatenatedProduct(base: Long): String = remainingConcatenatedProduct(base)

  @tailrec
  private def remainingConcatenatedProduct(base: Long, n: Int = 1, beginning: String = ""): String = {
    val nextPart = (base * n).toString
    if (nextPart.length + beginning.length > maxLength) beginning
    else remainingConcatenatedProduct(base, n + 1, beginning + nextPart)
  }

  private def isPandigital(num: String): Boolean = digits.forall(num.contains(_))
}
