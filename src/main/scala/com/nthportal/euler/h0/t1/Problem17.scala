package com.nthportal.euler
package h0.t1

import com.nthportal.euler.maths.NumericFormat

object Problem17 extends ProjectEulerProblem {
  private val numbers = Map(
    1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six",
    7 -> "seven", 8 -> "eight", 9 -> "nine", 10 -> "ten", 11 -> "eleven",
    12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen",
    16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen"
  )

  private val tens = Map(
    2 -> "twenty", 3 -> "thirty", 4 -> "forty", 5 -> "fifty",
    6 -> "sixty", 7 -> "seventy", 8 -> "eighty", 9 -> "ninety"
  )

  private val twoZeros = List(0, 0)

  override def apply(): Long = {
    (1 to 1000).toStream
      .map(_.digits)
      .map(numAsStr)
      .flatMap(_.toStream)
      .count(c => c != ' ' && c != '-')
  }

  /**
    *  Only works for numbers up to 1000
    *  Really ugly
    */
  private def numAsStr(digits: Seq[Int]): String = {
    digits.length match {
      case 4 => "one thousand"
      case 3 => threeDigitsAsStr(digits)
      case 2 => twoDigitsAsStr(digits)
      case 1 => numbers(firstDigit(digits))
    }
  }

  private def firstDigit(digits: Seq[Int]): Int = digits.head

  private def threeDigitsAsStr(digits: Seq[Int]): String = {
    numbers(firstDigit(digits)) + " hundred" +  {
      if (digits.takeRight(2) == twoZeros) ""
      else " and " + {
        if (digits(1) == 0) numAsStr(digits.drop(2))
        else numAsStr(digits.tail)
      }
    }
  }

  private def twoDigitsAsStr(digits: Seq[Int]): String = {
    if (digits.head == 1) numbers(NumericFormat.fromDigits(digits))
    else if (digits.last == 0) tens(firstDigit(digits))
    else tens(firstDigit(digits)) + "-" + numAsStr(digits.tail)
  }
}
