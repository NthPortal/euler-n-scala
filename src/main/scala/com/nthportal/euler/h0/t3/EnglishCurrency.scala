package com.nthportal.euler.h0.t3

private[t3] sealed abstract case class EnglishCurrency(pence: Int)

private[t3] object EnglishCurrency {
  def coins = List(TwoPound, OnePound, FiftyPence, TwentyPence, TenPence, FivePence, TwoPence, OnePence)

  object OnePence extends EnglishCurrency(1)

  object TwoPence extends EnglishCurrency(2)

  object FivePence extends EnglishCurrency(5)

  object TenPence extends EnglishCurrency(10)

  object TwentyPence extends EnglishCurrency(20)

  object FiftyPence extends EnglishCurrency(50)

  object OnePound extends EnglishCurrency(100)

  object TwoPound extends EnglishCurrency(200)

}
