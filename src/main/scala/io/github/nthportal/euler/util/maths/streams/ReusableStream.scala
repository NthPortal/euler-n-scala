package io.github.nthportal.euler.util.maths.streams

private[streams] trait ReusableStream[T] {
  val get: Stream[T]
}
