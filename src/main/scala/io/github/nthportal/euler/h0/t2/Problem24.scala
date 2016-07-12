package io.github.nthportal.euler
package h0.t2

import io.github.nthportal.euler.util.maths

object Problem24 extends ProjectEulerProblem {
  private val numbers = (0 to 9).toList
  private val goal = 1000000

  override def apply(): Long = {
    maths.permutationsOf(numbers)
      .drop(goal - 1)
      .head
      .map(_.toString)
      .fold(""){_ + _}
      .toLong
  }
}
