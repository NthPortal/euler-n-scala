package com.nthportal.euler.maths.streams

import com.nthportal.euler.maths
import com.nthportal.euler.maths.streams

class Primes private[streams]() extends ReusableStream[Long] {
  import maths.Primes._
  private val stream: Stream[Long] = 3 #:: streams.oddNaturals().drop(2).filter(firstFactor(_, stream).isEmpty)
  val get: Stream[Long] = 2 #:: stream
}
