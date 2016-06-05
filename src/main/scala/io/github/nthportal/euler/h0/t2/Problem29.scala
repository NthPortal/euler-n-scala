package io.github.nthportal.euler
package h0.t2

import scala.annotation.tailrec

object Problem29 extends ProjectEulerProblem {
  private val range = 2 to 100

  override def apply(): Long = {
    {
      for { a <- range
            b <- range
      } yield pow(a, b)
    }.toSet
      .size
  }

  @tailrec
  private def pow(a: Int, b: Int, prevResult: BigInt = 1): BigInt = b match {
    case 0 => prevResult
    case _ => pow(a, b - 1, prevResult * a)
  }
}
