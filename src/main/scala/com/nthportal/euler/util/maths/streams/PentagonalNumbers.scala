package com.nthportal.euler.util.maths
package streams

class PentagonalNumbers private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = streams.naturals().map(i => i * (3 * i - 1) / 2)
}
