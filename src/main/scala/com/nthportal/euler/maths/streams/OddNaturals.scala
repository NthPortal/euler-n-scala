package com.nthportal.euler.maths.streams

class OddNaturals extends ReusableStream[Long] {
  override val get: Stream[Long] = Stream.iterate[Long](1) { _ + 2 }
}
