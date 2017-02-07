package com.nthportal.euler.maths

import scala.annotation.tailrec

sealed abstract case class BigFraction private(numerator: BigInt, denominator: BigInt) {
  final def reciprocal: BigFraction = BigFraction(denominator, numerator)
}

object BigFraction {
  private val ops = implicitly[Integral[BigInt]]

  implicit object BigFractionIsFractional extends Fractional[BigFraction] {
    override def fromInt(x: Int): BigFraction = apply(x, 1)
    override def toInt(x: BigFraction): Int = toLong(x).toInt
    override def toLong(x: BigFraction): Long = x.numerator.toLong / x.denominator.toLong
    override def toFloat(x: BigFraction): Float = x.numerator.toFloat / x.denominator.toLong
    override def toDouble(x: BigFraction): Double = x.numerator.toDouble / x.denominator.toDouble

    override def negate(x: BigFraction): BigFraction = apply(-x.numerator, x.denominator)
    override def plus(x: BigFraction, y: BigFraction): BigFraction = {
      val gcf = gcd(x.denominator, y.denominator)
      val numerator = (x.numerator * y.denominator / gcf) + (y.numerator * x.denominator / gcf)
      apply(numerator, x.denominator / gcf * y.denominator)
    }
    override def minus(x: BigFraction, y: BigFraction): BigFraction = {
      val gcf = gcd(x.denominator, y.denominator)
      val numerator = (x.numerator * y.denominator / gcf) - (y.numerator * x.denominator / gcf)
      apply(numerator, x.denominator / gcf * y.denominator)
    }
    override def times(x: BigFraction, y: BigFraction): BigFraction = {
      apply(x.numerator * y.numerator, x.denominator * y.denominator)
    }
    override def div(x: BigFraction, y: BigFraction): BigFraction = {
      if (y.numerator == ops.zero) throw new ArithmeticException("Division by 0")
      apply(x.numerator * y.denominator, x.denominator * y.numerator)
    }

    override def compare(x: BigFraction, y: BigFraction): Int = x.toDouble compare y.toDouble // TODO: Maybe change later?
  }

  def apply(numerator: BigInt, denominator: BigInt): BigFraction = {
    if (denominator == 0) throw new ArithmeticException("BigFraction cannot have a denominator of 0")

    val n = ops.abs(numerator) * ops.signum(numerator) * ops.signum(denominator)
    val d = ops.abs(denominator)
    val gcf = gcd(n, d)
    new BigFraction(n / gcf, d / gcf) {}
  }

  private def gcd(a: BigInt, b: BigInt): BigInt = if (a > b) gcdRec(a, b) else gcdRec(b, a)

  @tailrec
  private def gcdRec(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcdRec(b, a % b)
}
