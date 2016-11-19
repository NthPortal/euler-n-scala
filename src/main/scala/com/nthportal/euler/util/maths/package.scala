package com.nthportal.euler.util

import com.nthportal.euler.util.maths.streams.Naturals

import scala.annotation.tailrec

package object maths {
  /* choose and factorial */

  def choose(n: Long, k: Long): BigInt = partialFactorial(n, math.max(k, n - k)) / factorial(math.min(k, n - k))

  def factorial(n: Int): BigInt = factorial(n.toLong)

  def factorial(n: Long): BigInt = {
    n match {
      case 0 => 1
      case i if i < 0 => throw new IllegalArgumentException("Cannot calculate factorial of negative number")
      case _ => partialFactorial(n, 1)
    }
  }

  @tailrec
  private def partialFactorial(n: Long, stop: Long, prevResult: BigInt = 1): BigInt = {
    if (n > stop) partialFactorial(n - 1, stop, prevResult * n)
    else prevResult
  }

  /* seq permutations */

  def permutationsOf(numbers: Seq[Int]): Stream[Seq[Int]] = permutationsFrom(numbers.sorted)

  private def permutationsFrom(numbers: Seq[Int]): Stream[Seq[Int]] = {
    if (numbers.isEmpty) Stream.empty
    else if (numbers.length == 1) Stream(numbers)
    else numbers #:: permutationsFrom(permute(numbers, numbers.length - 2)())
  }

  @tailrec
  private def permute(numbers: Seq[Int], index: Int)(swapWithIndex: Int = numbers.length - 1): Seq[Int] = {
    if (numbers(index) < numbers(swapWithIndex)) {
      numbers.slice(0, index) ++:
        numbers(swapWithIndex) +:
        numbers.slice(swapWithIndex + 1, numbers.length).reverse ++:
        numbers(index) +:
        numbers.slice(index + 1, swapWithIndex).reverse
    } else if (swapWithIndex == index + 1) {
      if (index == 0) List.empty
      else permute(numbers, index - 1)(numbers.length - 1)
    } else {
      permute(numbers, index)(swapWithIndex - 1)
    }
  }

  /* integer exponents */
  @inline
  private def exponentChecks(a: Long, b: Long): Unit = {
    require(b >= 0, "Integral exponentiation not supported for negative values")
    if (a == 0 && b == 0) throw new ArithmeticException("0 power 0 not defined")
  }

  def pow(a: Long, b: Long): Long = {
    exponentChecks(a, b)
    powImpl(a, b)
  }

  def bigPow(a: Long, b: Long): BigInt = {
    exponentChecks(a, b)
    bigPowImpl(a, b)
  }

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

  /* fibonacci */

  def fibonacciFrom(n1: Long, n2: Long): Stream[Long] = n1 #:: fibonacciFrom(n2, n1 + n2)

  def bigFibonacciFrom(n1: BigInt, n2: BigInt): Stream[BigInt] = n1 #:: bigFibonacciFrom(n2, n1 + n2)

  /* divisors */

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

  /* Distance between values */

  def dist(a: Long, b: Long): Long = math.abs(a - b)

  def dist(a: Int, b: Int): Int = math.abs(a - b)

  def dist(a: Double, b: Double): Double = math.abs(a - b)
}
