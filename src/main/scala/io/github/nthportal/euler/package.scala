package io.github.nthportal

import io.github.nthportal.euler.util.maths

import scala.collection.{GenSetLike, SeqLike}

/**
  * Custom Predef
  */
package object euler {
  /* Exponents */
  // Value classes cannot be made members of traits, so these cannot
  // be moved to util.maths

  implicit final class CustomRichLong(private val a: Long) extends AnyVal {
    def **(b: Long) = maths.pow(a, b)
    def **(b: Int) = maths.pow(a, b)
    def divides(b: Long): Boolean = b % a == 0
    def divides(b: Int): Boolean = b % a == 0
    def isEven: Boolean = 2 divides a
  }

  implicit final class CustomRichInt(private val a: Int) extends AnyVal {
    def **(b: Long) = maths.pow(a, b)
    def **(b: Int) = maths.pow(a, b)
    def divides(b: Long): Boolean = b % a == 0
    def divides(b: Int): Boolean = b % a == 0
    def isEven: Boolean = 2 divides a
  }

  implicit final class CustomRichDouble(private val a: Double) extends AnyVal {
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

  implicit class ObjInGenSetLike[A, Repr](obj: A) {
    def in(seqLike: GenSetLike[A, Repr]): Boolean = seqLike contains obj
    def notIn(seqLike: GenSetLike[A, Repr]): Boolean = !in(seqLike)
  }
}
