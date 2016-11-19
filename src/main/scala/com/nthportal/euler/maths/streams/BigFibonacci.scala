package com.nthportal.euler.maths.streams

import com.nthportal.euler.maths

class BigFibonacci private[streams]() extends ReusableStream[BigInt] {
  override val get: Stream[BigInt] = maths.bigFibonacciFrom(1, 1)
}
