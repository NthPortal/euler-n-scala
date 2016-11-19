package com.nthportal.euler.util.maths.streams

import com.nthportal.euler.util.maths.streams

class HexagonalNumbers private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = streams.naturals().map(i => i * (2 * i - 1))
}
