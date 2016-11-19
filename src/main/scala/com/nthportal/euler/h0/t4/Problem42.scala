package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.{CachingStreamChecker, streams}

object Problem42 extends ProjectEulerProblem {
  override def apply(): Long = {
    val checker = new CachingStreamChecker(streams.triangleNumbers())

    Problem42Helper.words
      .toStream
      .map(_.toStream.map(_.toLong - 'A' + 1).sum)
      .count(checker.isInStream)
  }
}
