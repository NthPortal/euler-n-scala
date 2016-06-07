package io.github.nthportal

import io.github.nthportal.euler.util.maths

/**
  * Custom Predef
  */
package object euler {
  implicit final class LongPow(private val a: Long) extends AnyVal {
    def **(b: Long) = maths.pow(a, b)
    def **(b: Int) = maths.pow(a, b)
  }

  implicit final class IntPow(private val a: Int) extends AnyVal {
    def **(b: Long) = maths.pow(a, b)
    def **(b: Int) = maths.pow(a, b)
  }

  implicit final class DoublePow(private val a: Double) extends AnyVal {
    def **(b: Double) = math.pow(a, b)
  }
}
