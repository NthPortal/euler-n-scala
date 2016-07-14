package io.github.nthportal.euler
package h0.t4

import scala.annotation.tailrec
import scala.collection.mutable

object Problem42 extends ProjectEulerProblem {
  override def apply(): Long = {
    val checker = new TriangleNumberChecker

    Problem42Helper.words
      .toStream
      .map(_.toStream.map(_.toLong - 'A' + 1).sum)
      .count(checker.isTriangleNumber)
  }

  private class TriangleNumberChecker {
    private val cache = mutable.HashSet[Long]()
    private var triangleStream = triangleNumbers()

    @tailrec
    final def isTriangleNumber(n: Long): Boolean = {
      if (n < triangleStream.head) {
        n in cache
      } else {
        cache += triangleStream.head
        triangleStream = triangleStream.tail
        isTriangleNumber(n)
      }
    }

    private def triangleNumbers(index: Long = 1): Stream[Long] = {
      (index * (index + 1) / 2) #:: triangleNumbers(index + 1)
    }
  }

}
