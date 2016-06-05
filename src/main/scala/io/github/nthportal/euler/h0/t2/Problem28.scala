package io.github.nthportal.euler
package h0.t2

import scala.annotation.tailrec

object Problem28 extends ProjectEulerProblem {
  override def apply(): Long = {
    {
      for { i <- 2 to 1000 by 2
            pc = previousCount(i - 2)
            j <- 1 to 4
      } yield j * i + pc
    }.sum + 1
  }

  @tailrec
  private def previousCount(difference: Int, prevSum: Int = 0): Long = difference match {
    case 0 => prevSum + 1
    case _ => previousCount(difference - 2, prevSum + (4 * difference))
  }
}
