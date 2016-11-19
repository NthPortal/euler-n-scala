package io.github.nthportal.euler
package h0.t4

import io.github.nthportal.euler.util.maths.{Primes, streams}

import scala.annotation.tailrec

object Problem47 extends ProjectEulerProblem {
  override def apply(): Long = {
    val primes = streams.primes
    val with3Distinct = streams.naturals()
      .filter(Primes.primeFactors(_, primes).toSet.size >= 4)

    groupWithNext3(with3Distinct)
      .filter(isConsecutive)
      .head
      .head
  }

  def groupWithNext3(stream: Stream[Long]): Stream[Seq[Long]] = stream.take(4) #:: groupWithNext3(stream.tail)

  def isConsecutive(seq: Seq[Long]): Boolean = isConsecutiveImpl(seq, seq.head)

  @tailrec
  def isConsecutiveImpl(seq: Seq[Long], expected: Long): Boolean = {
    if (seq.isEmpty) true
    else if (seq.head != expected) false
    else isConsecutiveImpl(seq.tail, expected + 1)
  }
}
