package com.nthportal.euler
package h0.t3

import com.nthportal.euler.util.maths.Fraction

object Problem33 extends ProjectEulerProblem {
  import Fraction.FractionIsNumeric._

  override def apply(): Long = {
    {
      for { shared <- 1 to 9
            numeratorOther <- 0 to 9
            denominatorOther <- 1 to 9
            if numeratorOther != denominatorOther
            f <- fractionsFrom(shared, numeratorOther, denominatorOther)
            if f.toDouble < 1
            if f == Fraction(numeratorOther, denominatorOther)
      } yield f
    }.product
      .denominator
  }

  private def fractionsFrom(shared: Int, numeratorOther: Int, denominatorOther: Int): Seq[Fraction] = {
    if (numeratorOther == 0) Seq(fraction1(shared, numeratorOther, denominatorOther))
    else if (denominatorOther == 0) Seq(fraction2(shared, numeratorOther, denominatorOther))
    else Seq(fraction1(shared, numeratorOther, denominatorOther), fraction2(shared, numeratorOther, denominatorOther))
  }

  private def fraction1(shared: Int, numeratorOther: Int, denominatorOther: Int): Fraction = {
    Fraction(10 * shared + numeratorOther, 10 * denominatorOther + shared)
  }

  private def fraction2(shared: Int, numeratorOther: Int, denominatorOther: Int): Fraction = {
    Fraction(10 * numeratorOther + shared, 10 * shared + denominatorOther)
  }
}
