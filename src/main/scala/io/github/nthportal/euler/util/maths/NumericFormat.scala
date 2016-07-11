package io.github.nthportal.euler.util.maths

object NumericFormat {
  def isPalindrome(num: Long): Boolean = {
    val str = num.toString
    str == str.reverse
  }

  def isBinaryPalindrome(num: Long): Boolean = {
    val str = num.toBinaryString
    str == str.reverse
  }
}
