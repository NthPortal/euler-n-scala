package io.github.nthportal.euler
package h0.t3

object Problem31 extends ProjectEulerProblem {
  private val zeroList = List(0)

  override def apply(): Long = {
    EnglishCurrency.coins
      .filterNot(_ eq EnglishCurrency.OnePence)
      .foldLeft(List(200))((penceRemaining, coin) => {
        penceRemaining.flatMap(p => {
          if (p == 0) zeroList
          else p to (p % coin.pence) by (-coin.pence)
        })
      })
      .length
  }
}
