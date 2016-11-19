package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.streams

import scala.annotation.tailrec

object Problem48 extends ProjectEulerProblem {
  private val big10 = BigInt(10)

  override def apply(): Long = {
    val sum = streams.naturals().take(1000)
      .map(n => maths.bigPow(n, n))
      .sum

    lastNDigits(10, sum).asNumber
  }

  @tailrec
  def lastNDigits(n: Int, num: BigInt, prev: List[Int] = Nil): Seq[Int] = {
    if (n <= 0) prev
    else {
      val (d, r) = num /% big10
      lastNDigits(n - 1, d, r.toInt :: prev)
    }
  }
}
