package io.github.nthportal

import io.github.nthportal.euler.util.maths

import scala.collection.SeqLike

/**
  * Custom Predef
  */
package object euler {
  /* Exponents */

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

  /* elem in seq */

  implicit class CharSeqInString(seq: CharSequence) {
    def in(other: String): Boolean = other contains seq
    def notIn(other: String): Boolean = !in(other)
  }

  implicit class ObjInSeqLike[A, A1 >: A, Repr](obj: A1) {
    def in(seqLike: SeqLike[A, Repr]): Boolean = seqLike contains obj
    def notIn(seqLike: SeqLike[A, Repr]): Boolean = !in(seqLike)
  }
}
