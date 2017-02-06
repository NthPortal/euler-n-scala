package com.nthportal

import com.nthportal.euler.maths.{NumericFormat, Primes}
import com.nthportal.euler.maths.streams.Primes

import scala.collection.{GenMapLike, GenSetLike, SeqLike}
import scala.language.implicitConversions

/**
  * Custom Predef
  */
package object euler {
  private val big2 = BigInt(2)

  /* Numeric methods */
  // Value classes cannot be made members of traits, so these cannot
  // be moved to util.maths

  implicit final class CustomRichInt(private val a: Int) extends AnyVal {
    def **(b: Int): Long = maths.pow(a, b)
    def **(b: Long): Long = maths.pow(a, b)
    def ***(b: Long): BigInt = maths.bigPow(a, b)
    def ^^(b: Long): BigInt = maths.knuthUpArrow2(a, b)
    def divides(b: Int): Boolean = b % a == 0
    def divides(b: Long): Boolean = b % a == 0
    def divides(b: BigInt): Boolean = b % a == 0
    def isEven: Boolean = 2 divides a
    def digits: List[Int] = NumericFormat.digitsOf(a)
    def ! : BigInt = maths.factorial(a)
    def isPrime(implicit primes: Primes): Boolean = Primes.isPrime(a, primes)
  }

  implicit final class CustomRichLong(private val a: Long) extends AnyVal {
    def **(b: Int): Long = maths.pow(a, b)
    def **(b: Long): Long = maths.pow(a, b)
    def ***(b: Long): BigInt = maths.bigPow(a, b)
    def ^^(b: Long): BigInt = maths.knuthUpArrow2(a, b)
    def divides(b: Int): Boolean = b % a == 0
    def divides(b: Long): Boolean = b % a == 0
    def divides(b: BigInt): Boolean = b % a == 0
    def isEven: Boolean = 2 divides a
    def digits: List[Int] = NumericFormat.digitsOf(a)
    def ! : BigInt = maths.factorial(a)
    def isPrime(implicit primes: Primes): Boolean = Primes.isPrime(a, primes)
    def choose(k: Long): BigInt = maths.choose(a, k)
  }

  implicit final class CustomRichBigInt(private val a: BigInt) extends AnyVal {
    def isEven: Boolean = a % big2 == 0
    def digits: List[Int] = NumericFormat.digitsOf(a)
  }

  implicit final class CustomRichDouble(private val a: Double) extends AnyVal {
    def **(b: Double): Double = math.pow(a, b)
  }

  implicit class DigitsToLong(private val seq: Seq[Int]) extends AnyVal {
    def asNumber: Long = NumericFormat.fromDigits(seq)
    def asBigNumber: BigInt = NumericFormat.bigFromDigits(seq)
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
