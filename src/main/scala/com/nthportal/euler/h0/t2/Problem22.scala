package com.nthportal.euler
package h0.t2

object Problem22 extends ProjectEulerProblem {
  override def apply(): Long = {
    val namesAsLong = Problem22Helper.names
      .toStream
      .sorted
      .map(_.toStream.map(_.toLong - 'A' + 1).sum)
    val multiplied = for (i <- namesAsLong.indices) yield namesAsLong(i) * (i + 1)
    multiplied.sum
  }
}
