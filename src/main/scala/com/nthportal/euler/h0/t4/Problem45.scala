package com.nthportal.euler
package h0.t4

import com.nthportal.euler.maths.streams

import scala.annotation.tailrec

object Problem45 extends ProjectEulerProblem {
  override def apply(): Long = {
    val triangles = dropSmall(streams.triangleNumbers())
    val pentagonals = dropSmall(streams.pentagonalNumbers())
    val hexagonals = dropSmall(streams.hexagonalNumbers())

    findEqual(triangles, pentagonals, hexagonals)
  }

  def dropSmall(stream: Stream[Long]): Stream[Long] = stream.dropWhile(_ <= 40755)

  @tailrec
  def findEqual(s1: Stream[Long], s2: Stream[Long], s3: Stream[Long]): Long = {
    if (s1.head < s2.head || s1.head < s3.head) findEqual(s1.tail, s2, s3)
    else if (s2.head < s1.head || s2.head < s3.head) findEqual(s1, s2.tail, s3)
    else if (s3.head < s1.head || s3.head < s2.head) findEqual(s1, s2, s3.tail)
    else s1.head
  }
}
