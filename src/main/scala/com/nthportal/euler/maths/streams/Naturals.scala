package com.nthportal.euler.maths.streams

class Naturals private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = Stream.iterate(1L){_ + 1}
}
