package io.github.nthportal.euler.util.maths.streams

class Naturals private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = Stream.iterate(1L){_ + 1}
}
