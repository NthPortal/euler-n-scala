package com.nthportal.euler
package h0.t5

import com.nthportal.euler.util.cards.Card
import com.nthportal.euler.util.cards.poker.PokerHand

object Problem54 extends ProjectEulerProblem {
  override def apply(): Long = {
    Problem54Helper.hands
      .map { s =>
        (s split ' ')
          .grouped(5)
          .map {_ map Card.fromShortString}
          .map { a => PokerHand(a.toSeq) }
          .toList
      }
      .map { case List(a, b) => a > b }
      .count(identity)
  }
}
