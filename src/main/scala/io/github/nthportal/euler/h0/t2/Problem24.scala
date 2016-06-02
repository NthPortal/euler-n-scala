package io.github.nthportal.euler
package h0.t2

import scala.annotation.tailrec

object Problem24 extends ProjectEulerProblem {
  private val numbers = (0 to 9).toList
  private val goal = 1000000

  override def apply(): Long = {
    permutationsFrom(numbers)
      .drop(goal - 1)
      .head
      .map(_.toString)
      .fold(""){_ + _}
      .toLong
  }

  private def permutationsFrom(numbers: List[Int]): Stream[List[Int]] = {
    numbers #:: permutationsFrom(permute(numbers, numbers.length - 2))
  }

  @tailrec
  private def permute(numbers: List[Int], index: Int)(implicit swapWithIndex: Int = numbers.length - 1): List[Int] = {
    if (numbers(index) < numbers(swapWithIndex)) {
      numbers.slice(0, index) :::
        numbers(swapWithIndex) ::
        numbers.slice(swapWithIndex + 1, numbers.length).reverse :::
        numbers(index) ::
        numbers.slice(index + 1, swapWithIndex).reverse
    } else if (swapWithIndex == index + 1) {
      permute(numbers, index - 1)(numbers.length - 1)
    } else {
      permute(numbers, index)(swapWithIndex - 1)
    }
  }
}
