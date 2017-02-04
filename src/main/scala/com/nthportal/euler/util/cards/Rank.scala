package com.nthportal.euler.util.cards

object Rank extends Enumeration {
  type Rank = Value
  val Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace = Value

  @throws[IllegalArgumentException]
  def fromChar(char: Char): Rank = char match {
    case c if ('2' to '9') contains c => values.toIndexedSeq(c.asDigit - 2)
    case 'T' => Ten
    case 'J' => Jack
    case 'Q' => Queen
    case 'K' => King
    case 'A' => Ace
    case c => throw new IllegalArgumentException("Illegal rank character: " + c)
  }

  implicit val rankOrdering: Ordering[Rank] = Ordering.by(_.id)
}
