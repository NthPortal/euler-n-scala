package com.nthportal.euler
package h0.t2

import com.nthportal.euler.maths.streams

object Problem27 extends ProjectEulerProblem {
  override def apply(): Long = {
    implicit val primes = streams.primes

    for {
      a <- -999 to 999
      b <- primes().takeWhile(_ < 1000)
      length = Stream.iterate(0) {_ + 1}
        .map(n => n * n + a * n + b)
        .takeWhile(_.isPrime)
        .length
    } yield (a * b, length)

  }.maxBy(_._2)
    ._1
}
