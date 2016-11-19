package com.nthportal.euler.util.maths
package streams

import com.nthportal.euler.util.maths

class Fibonacci private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = maths.fibonacciFrom(1, 1)
}
