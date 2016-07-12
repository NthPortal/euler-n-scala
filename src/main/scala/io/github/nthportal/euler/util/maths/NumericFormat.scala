package io.github.nthportal.euler.util.maths

import scala.annotation.tailrec

object NumericFormat {
  def isPalindrome(num: Long): Boolean = {
    val str = num.toString
    str == str.reverse
  }

  def isBinaryPalindrome(num: Long): Boolean = {
    val str = num.toBinaryString
    str == str.reverse
  }

  /* digits* */

  def digitsOf(n: Long): List[Long] = carryDigits(n, Nil)

  @tailrec
  private def carryDigits (n: Long, carry: List[Long]): List [Long] = {
    if (n < 10) n :: carry
    else carryDigits (n/10, (n % 10) :: carry)
  }

  def fromDigits(digits: Seq[Long]): Long = digits.foldLeft(0L){ _ * 10 + _ }
}
