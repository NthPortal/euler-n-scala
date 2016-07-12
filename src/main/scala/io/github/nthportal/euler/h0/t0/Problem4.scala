package io.github.nthportal.euler.h0.t0

import io.github.nthportal.euler.ProjectEulerProblem
import io.github.nthportal.euler.util.maths.NumericFormat

object Problem4 extends ProjectEulerProblem {
  override def apply(): Long = {
    {
      for {i <- 100 to 999
           j <- 100 to 999
           product = i * j
           if NumericFormat.isPalindrome(product)
      } yield product
    }.max
  }


}
