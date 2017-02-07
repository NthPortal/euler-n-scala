package com.nthportal.euler.maths

import scala.annotation.tailrec

sealed abstract case class Fraction private(numerator: Int, denominator: Int)

object Fraction {
  implicit object FractionIsFractional extends Fractional[Fraction] {
    override def fromInt(x: Int): Fraction = apply(x, 1)
    override def toInt(x: Fraction): Int = x.numerator / x.denominator
    override def toLong(x: Fraction): Long = toInt(x).toLong
    override def toFloat(x: Fraction): Float = x.numerator.toFloat / x.denominator
    override def toDouble(x: Fraction): Double = x.numerator.toDouble / x.denominator

    override def negate(x: Fraction): Fraction = apply(-x.numerator, x.denominator)
    override def plus(x: Fraction, y: Fraction): Fraction = {
      val gcf = gcd(x.denominator, y.denominator)
      val numerator = (x.numerator * y.denominator / gcf) + (y.numerator * x.denominator / gcf)
      apply(numerator, x.denominator / gcf * y.denominator)
    }
    override def minus(x: Fraction, y: Fraction): Fraction = {
      val gcf = gcd(x.denominator, y.denominator)
      val numerator = (x.numerator * y.denominator / gcf) - (y.numerator * x.denominator / gcf)
      apply(numerator, x.denominator / gcf * y.denominator)
    }
    override def times(x: Fraction, y: Fraction): Fraction = {
      apply(x.numerator * y.numerator, x.denominator * y.denominator)
    }
    override def div(x: Fraction, y: Fraction): Fraction = {
      if (y.numerator == 0) throw new ArithmeticException("Division by 0")
      apply(x.numerator * y.denominator, x.denominator * y.numerator)
    }

    override def compare(x: Fraction, y: Fraction): Int = x.toDouble compare y.toDouble // TODO: Maybe change later?
  }

  def apply(numerator: Int, denominator: Int): Fraction = {
    if (denominator == 0) throw new ArithmeticException("Fraction cannot have a denominator of 0")

    val n = math.abs(numerator) * math.signum(numerator) * math.signum(denominator)
    val d = math.abs(denominator)
    val gcf = gcd(n, d)
    new Fraction(n / gcf, d / gcf) {}
  }

  private def gcd(a: Int, b: Int): Int = if (a > b) gcdRec(a, b) else gcdRec(b, a)

  @tailrec
  private def gcdRec(a: Int, b: Int): Int = if (b == 0) a else gcdRec(b, a % b)
}
