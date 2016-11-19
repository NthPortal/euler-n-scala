package com.nthportal.euler.util.maths.streams

import com.nthportal.euler.util.maths

class BigFibonacci private[streams]() extends ReusableStream[BigInt] {
  override val get: Stream[BigInt] = maths.bigFibonacciFrom(1, 1)
}
