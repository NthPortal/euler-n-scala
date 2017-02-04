package com.nthportal.euler
package util.cards
package poker

import com.nthportal.euler.util.cards.Card._
import com.nthportal.euler.util.cards.Rank._

import scala.Ordering._

case class PokerHand private(cards: List[Card]) extends Ordered[PokerHand] {

  import PokerHand._

  override def compare(that: PokerHand): Int = Classification(this) compare Classification(that)
}

object PokerHand {
  def apply(cards: Seq[Card]): PokerHand = {
    require(cards.size == 5, "poker hands must have exactly 5 cards")
    new PokerHand(cards.sorted.toList)
  }

  object HandClassification extends Enumeration {
    type HandClassification = Value
    val
    HighCard,
    OnePair,
    TwoPairs,
    ThreeOfAKind,
    Straight,
    Flush,
    FullHouse,
    FourOfAKind,
    StraightFlush,
    RoyalFlush = Value
  }

  import HandClassification._

  private case class Classification(hand: PokerHand) extends Ordered[Classification] {

    import Classification._

    private def cards = hand.cards

    private val straight = isStraight(hand)
    private val flush = isFlush(hand)
    private val grouped = cards
      .map(_.rank)
      .groupBy(identity)
      .map { case (r, rs) => (r, rs.length) }
      .toSeq
      .sortBy { case (rank, count) => (count, rank) }

    val get: HandClassification =
      if (straight && flush) {
        if (cards.head.rank == Rank.Ten) RoyalFlush
        else StraightFlush
      } else grouped map {_._2} match {
        case Seq(1, 4) => FourOfAKind
        case Seq(2, 3) => FullHouse
        case counts =>
          if (flush) Flush
          else if (straight) Straight
          else counts match {
            case Seq(1, 1, 3) => ThreeOfAKind
            case Seq(1, 2, 2) => TwoPairs
            case Seq(1, 1, 1, 2) => OnePair
            case Seq(1, 1, 1, 1, 1) => HighCard
          }
      }

    override def compare(that: Classification): Int = {
      val res = this.get compare that.get
      if (res != 0) res
      else {
        get match {
          case RoyalFlush => 0
          case StraightFlush | Straight => this.cards.head compare that.cards.head
          case FourOfAKind => fourOfAKindOrdering.compare(this, that)
          case FullHouse => fullHouseOrdering.compare(this, that)
          case Flush => flushOrdering.compare(this, that)
          case ThreeOfAKind => threeOfAKindOrdering.compare(this, that)
          case TwoPairs => twoPairsOrdering.compare(this, that)
          case OnePair => onePairOrdering.compare(this, that)
          case HighCard => highCardOrdering.compare(this, that)
        }
      }
    }
  }

  private object Classification {
    private val fourOfAKindOrdering: Ordering[Classification] = Ordering.by(c => (c.grouped(1)._1, c.grouped.head._1))
    private val fullHouseOrdering: Ordering[Classification] = Ordering.by(_.grouped(1)._1)
    private val flushOrdering: Ordering[Classification] =
      Ordering.by(c => (c.cards(4), c.cards(3), c.cards(2), c.cards(1), c.cards.head))
    private val threeOfAKindOrdering: Ordering[Classification] =
      Ordering.by(c => (c.grouped(2)._1, c.grouped(1)._1, c.grouped.head._1))

    private def twoPairsOrdering: Ordering[Classification] = threeOfAKindOrdering

    private val onePairOrdering: Ordering[Classification] =
      Ordering.by(c => (c.grouped(3)._1, c.grouped(2)._1, c.grouped(1)._1, c.grouped.head._1))

    private def highCardOrdering: Ordering[Classification] = flushOrdering
  }

  private def isStraight(hand: PokerHand): Boolean = {
    hand.cards.toStream
      .map(_.rank.id)
      .zipWithIndex
      .map { case (r, i) => r - i }
      .groupBy(identity)
      .size == 1
  }

  private def isFlush(hand: PokerHand): Boolean = {
    hand.cards
      .map(_.suit)
      .groupBy(identity)
      .size == 1
  }
}
