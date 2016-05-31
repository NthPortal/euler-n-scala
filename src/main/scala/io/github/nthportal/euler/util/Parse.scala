package io.github.nthportal.euler.util

import scala.annotation.tailrec

object Parse {
  @tailrec
  def twoDigitStringAsNum(s: String): Int = {
    if (s.startsWith("0")) twoDigitStringAsNum(s.substring(1))
    else if (s.isEmpty) 0
    else s.toInt
  }
}
