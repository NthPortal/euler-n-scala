package com.nthportal

import com.nthportal.euler.util.maths

import scala.collection.{GenMapLike, GenSetLike, SeqLike}

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

  implicit def int2Long(int: Int): Long = int.toLong
  implicit def long2Int(long: Long): Int = long.toInt

  /* elem in seq */

  implicit class CharSeqInString(private val seq: CharSequence) extends AnyVal {
    def in(other: String): Boolean = other contains seq
    def notIn(other: String): Boolean = !in(other)
  }

  implicit class ObjInSeqLike[A, A1 >: A, Repr,T](private val obj: A1) extends AnyVal {
    def in(seqLike: SeqLike[A, Repr]): Boolean = seqLike contains obj
    def notIn(seqLike: SeqLike[A, Repr]): Boolean = !in(seqLike)
  }

  implicit class ObjInGenSetLike[A, Repr](private val obj: A) extends AnyVal {
    def in(genSetLike: GenSetLike[A, Repr]): Boolean = genSetLike contains obj
    def notIn(genSetLike: GenSetLike[A, Repr]): Boolean = !in(genSetLike)
  }

  implicit class KeyInGenMapLike[A, B, Repr](private val key: A) extends AnyVal {
    def in(genMapLike: GenMapLike[A, B, Repr]): Boolean = genMapLike contains key
    def notIn(genMapLike: GenMapLike[A, B, Repr]): Boolean = !in(genMapLike)
  }
}
