package io.github.nthportal.euler
package h0.t1

import scala.annotation.tailrec

object Problem15 extends ProjectEulerProblem {
  override def apply(): Long = choose(40, 20).toLong

  private def choose(n: Long, k: Long): BigInt = partialFactorial(n, math.max(k, n - k)) / factorial(math.min(k, n - k))

  @tailrec
  private def partialFactorial(n: Long, stop: Long, prevResult: BigInt = 1): BigInt = {
    if (n > stop) partialFactorial(n - 1, stop, prevResult * n)
    else prevResult
  }

  private def factorial(n: Long): BigInt = partialFactorial(n, 1)
}
