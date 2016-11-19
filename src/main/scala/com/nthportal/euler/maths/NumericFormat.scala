package com.nthportal.euler
package maths

import scala.annotation.tailrec

object NumericFormat {
  private val big10 = BigInt(10)

  def twoDigitStringAsNum(s: String): Int = {
    require(s.length == 2, "Expected string of length 2 - actual length: " + s.length)
    twoDigitStringAsNumImpl(s)
  }

  @tailrec
  private def twoDigitStringAsNumImpl(s: String): Int = {
    if (s.startsWith("0")) twoDigitStringAsNumImpl(s.substring(1))
    else if (s.isEmpty) 0
    else s.toInt
  }

  def isPalindrome(num: Long): Boolean = {
    val str = digitsOf(num)
    str == str.reverse
  }

  def isBinaryPalindrome(num: Long): Boolean = {
    val str = num.toBinaryString
    str == str.reverse
  }

  @inline
  def isPandigital(num: Long): Boolean = isPandigital(num.toString)

  def isPandigital(num: String): Boolean = (1 to num.length).map(_.toString).forall(_ in num)

  /* digits */

  def digitsOf(n: Int): List[Int] = digitsOf(n.toLong)

  def digitsOf(n: Long): List[Int] = carryDigits(n)

  def digitsOf(n: BigInt): List[Int] = carryBigDigits(n)

  @tailrec
  private def carryDigits(n: Long, carry: List[Int] = Nil): List[Int] = {
    if (n < 10) n :: carry
    else carryDigits(n / 10, (n % 10) :: carry)
  }

  @tailrec
  private def carryBigDigits(n: BigInt, carry: List[Int] = Nil): List[Int] = {
    if (n < big10) n.toInt :: carry
    else {
      val (d, r) = n /% big10
      carryBigDigits(d, r.toInt :: carry)
    }
  }

  def fromDigits(digits: Seq[Int]): Long = digits.foldLeft(0L) {_ * 10 + _}
}
