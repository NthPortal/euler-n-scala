package com.nthportal.euler.util.cards

import com.nthportal.euler.util.cards.Rank.Rank
import com.nthportal.euler.util.cards.Suit.Suit

case class Card(rank: Rank, suit: Suit) extends Ordered[Card] {
  override def compare(that: Card): Int = Card.rankOnlyOrdering.compare(this, that)
}

object Card {
  implicit val rankOnlyOrdering: Ordering[Card] = Ordering.by(_.rank)

  @throws[IllegalArgumentException]
  def fromShortString(card: String): Card = card match {
    case CardLike(rank, suit) => Card(Rank.fromChar(rank), Suit.fromChar(suit))
    case _ => throw new IllegalArgumentException("Invalid card string: " + card)
  }

  private object CardLike {
    def unapply(arg: String): Option[(Char, Char)] = {
      if (arg.length == 2) Some(arg(0), arg(1))
      else None
    }
  }
}
