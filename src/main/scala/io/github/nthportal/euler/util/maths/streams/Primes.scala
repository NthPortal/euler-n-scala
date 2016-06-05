package io.github.nthportal.euler.util.maths.streams

import io.github.nthportal.euler.util.maths

class Primes private[streams]() extends ReusableStream[Long] {
  import maths.Primes._
  val get: Stream[Long] = 2 #:: oddNumbers.filter(firstFactor(_, get).isEmpty)
}
