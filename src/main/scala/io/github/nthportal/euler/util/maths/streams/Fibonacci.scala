package io.github.nthportal.euler.util.maths
package streams

import io.github.nthportal.euler.util.maths

class Fibonacci private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = maths.fibonacciFrom(1, 1)
}
