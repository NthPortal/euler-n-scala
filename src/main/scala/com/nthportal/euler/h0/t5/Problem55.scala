package com.nthportal.euler
package h0.t5

import com.nthportal.euler.maths.NumericFormat

object Problem55 extends ProjectEulerProblem {
  override def apply(): Long = {
    (1 until 10000)
      .map(palindromicStream)
      .filterNot(_.exists(NumericFormat.isPalindrome))
      .size
  }

  private def palindromicStream(num: Int): Stream[BigInt] = {
    Stream.iterate(BigInt(num))(sumWithReversed).slice(1, 50)
  }

  private def sumWithReversed(num: BigInt): BigInt = num + num.digits.reverse.asBigNumber
}
