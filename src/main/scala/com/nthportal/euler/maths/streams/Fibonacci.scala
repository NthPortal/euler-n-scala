package com.nthportal.euler.maths
package streams

import com.nthportal.euler.maths

class Fibonacci private[streams]() extends ReusableStream[Long] {
  override val get: Stream[Long] = maths.fibonacciFrom(1, 1)
}
