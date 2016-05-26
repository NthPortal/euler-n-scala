package io.github.nthportal.euler.h0.t0

import io.github.nthportal.euler.ProjectEulerProblem

object Problem4 extends ProjectEulerProblem {
  override def apply(): Long = {
    val palindromes =
      for {i <- 100 to 999
           j <- 100 to 999
           product = i * j
           if isPalindrome(product)
      } yield product
    palindromes.max
  }

  def isPalindrome(num: Long): Boolean = {
    val str = num.toString
    str == str.reverse
  }
}
