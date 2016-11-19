package com.nthportal.euler
package h0.t4

import com.nthportal.euler.util.maths.NumericFormat

object Problem40 extends ProjectEulerProblem {
  override def apply(): Long = {
    droppingStream(Stream.from(1).flatMap(NumericFormat.digitsOf), (0 to 6).map(10 ** _).map(_.toInt).toStream).product
  }

  private def droppingStream(stream: Stream[Int], targets: Stream[Int], alreadyDropped: Int = 0): Stream[Long] = {
    if (targets.isEmpty) {
      Stream.empty
    } else {
      val toDrop = targets.head - alreadyDropped - 1
      val newStream = stream.drop(toDrop)
      newStream.head #:: droppingStream(newStream.tail, targets.tail, targets.head)
    }
  }
}
