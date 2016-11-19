package com.nthportal.euler
package h0.t2

import com.nthportal.euler.util.maths
import com.nthportal.euler.util.maths.streams
import com.nthportal.euler.util.maths.streams.Naturals

object Problem21 extends ProjectEulerProblem {
  override def apply(): Long = {
    val naturals = streams.naturals
    naturals.get
      .takeWhile(_ < 10000)
      .filter(isFriendly(_, naturals))
      .sum
  }

  private def isFriendly(num: Long, naturals: Naturals): Boolean = {
    val other = possibleFriend(num, naturals)
    other != num && possibleFriend(other, naturals) == num
  }

  private def possibleFriend(num: Long, naturals: Naturals): Long = {
    maths.divisors(num, naturals).toStream.filterNot(_ == num).sum
  }
}
