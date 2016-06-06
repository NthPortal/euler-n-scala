package io.github.nthportal.euler.util

import io.github.nthportal.euler.util.maths.streams.Naturals

import scala.annotation.tailrec

package object maths {
  def choose(n: Long, k: Long): BigInt = partialFactorial(n, math.max(k, n - k)) / factorial(math.min(k, n - k))

  def factorial(n: Long): BigInt = {
    n match {
      case 0 => 1
      case i if i < 0 => throw new IllegalArgumentException("Cannot calculate factorial of negative number")
      case _ => partialFactorial(n, 1)
    }
  }

  def pow(a: Long, b: Long): Long = powImpl(a, b)

  def bigPow(a: Long, b: Long): BigInt = bigPowImpl(a, b)

  @tailrec
  private def powImpl(a: Long, b: Long, prevResult: Long = 1): Long = {
    if (b == 0) prevResult
    else powImpl(a, b - 1, prevResult * a)
  }

  @tailrec
  private def bigPowImpl(a: Long, b: Long, prevResult: BigInt = 1): BigInt = {
    if (b == 0) prevResult
    else bigPowImpl(a, b - 1, prevResult * a)
  }

  // Returns ordered list
  def divisors(num: Long, naturals: Naturals = streams.naturals): List[Long] = {
    val half = naturals.get
      .filter(num % _ == 0)
      .takeWhile(i => i * i < num)
      .toList

    val sqrtList = {
      val i = math.sqrt(num).toLong
      if (i * i == num) List(i) else Nil
    }

    half ::: sqrtList ::: half.reverse.map(num / _)
  }

  @tailrec
  private def partialFactorial(n: Long, stop: Long, prevResult: BigInt = 1): BigInt = {
    if (n > stop) partialFactorial(n - 1, stop, prevResult * n)
    else prevResult
  }
}
