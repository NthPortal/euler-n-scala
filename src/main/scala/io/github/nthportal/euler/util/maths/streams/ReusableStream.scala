package io.github.nthportal.euler.util.maths.streams

private[streams] trait ReusableStream[T] extends (() => Stream[T]) {
  val get: Stream[T]

  final override def apply(): Stream[T] = get
}
