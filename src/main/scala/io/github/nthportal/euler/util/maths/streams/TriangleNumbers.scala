package io.github.nthportal.euler.util.maths
package streams

class TriangleNumbers private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = streams.naturals().map(i => i * (i + 1) / 2)
}
