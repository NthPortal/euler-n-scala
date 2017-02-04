package com.nthportal.euler.util.cards

object Suit extends Enumeration {
  type Suit = Value
  val Clubs, Diamonds, Spades, Hearts = Value

  @throws[IllegalArgumentException]
  def fromChar(char: Char): Suit = char match {
    case 'C' => Clubs
    case 'D' => Diamonds
    case 'S' => Spades
    case 'H' => Hearts
    case c => throw new IllegalArgumentException("Illegal suit character: " + c)
  }
}
