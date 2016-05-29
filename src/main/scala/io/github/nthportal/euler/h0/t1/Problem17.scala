package io.github.nthportal.euler
package h0.t1

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

  override def apply(): Long = {
    (1 to 1000).toStream
      .map(_.toString)
      .map(numAsStr)
      .flatMap(_.toStream)
      .filterNot(_ == ' ')
      .filterNot(_ == '-')
      .length
  }

  /**
    *  Only works for numbers up to 1000
    *  Really ugly
    */
  private def numAsStr(num: String): String = {
    num.length match {
      case 4 => "one thousand"
      case 3 => threeDigitsAsStr(num)
      case 2 => twoDigitsAsStr(num)
      case 1 => numbers.get(firstDigit(num)).get
    }
  }

  private def firstDigit(num: String): Int = num.charAt(0).asDigit

  private def threeDigitsAsStr(num: String): String = {
    numbers.get(firstDigit(num)).get + " hundred" +  {
      if (num.endsWith("00")) ""
      else " and " + {
        if (num.charAt(1) == '0') numAsStr(num.substring(2))
        else numAsStr(num.substring(1))
      }
    }
  }

  private def twoDigitsAsStr(num: String): String = {
    if (num.startsWith("1")) numbers.get(num.toInt).get
    else if (num.endsWith("0")) tens.get(firstDigit(num)).get
    else tens.get(firstDigit(num)).get + "-" + numAsStr(num.substring(1))
  }
}
