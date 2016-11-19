package io.github.nthportal.euler
package h0.t4

import io.github.nthportal.euler.util.maths
import io.github.nthportal.euler.util.maths.streams.PentagonalNumbers
import io.github.nthportal.euler.util.maths.{CachingStreamChecker, streams}

object Problem44 extends ProjectEulerProblem {
  override def apply(): Long = {
    val pentagonals = streams.pentagonalNumbers
    val checker = new CachingStreamChecker(pentagonals())
    tupledStream(pentagonals, pentagonals())
      .filter({ case (a, b) => checker.isInStream(a - b) && checker.isInStream(a + b) })
      .map({ case (a, b) => maths.dist(a, b) })
      .head
  }

  private def tupledStream(pentagonals: PentagonalNumbers, stream: Stream[Long]): Stream[(Long, Long)] = {
    val max = stream.head
    val lesserStream = pentagonals().takeWhile(_ < max)
    Stream.continually(max).zip(lesserStream) #::: tupledStream(pentagonals, stream.tail)
  }
}
