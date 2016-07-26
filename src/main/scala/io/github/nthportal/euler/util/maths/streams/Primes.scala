package io.github.nthportal.euler.util.maths.streams

import io.github.nthportal.euler.util.maths

class Primes private[streams]() extends ReusableStream[Long] {
  import maths.Primes._
  private val stream: Stream[Long] = 3 #:: oddNumbers.drop(1).filter(firstFactor(_, stream).isEmpty)
  val get: Stream[Long] = 2 #:: stream
}
