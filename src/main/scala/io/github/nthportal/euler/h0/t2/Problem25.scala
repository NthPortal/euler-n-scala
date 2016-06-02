package io.github.nthportal.euler
package h0.t2

object Problem25 extends ProjectEulerProblem {
  override def apply(): Long = indexedFibonacciFrom(1, 1, 1).find(_._1.toString.length >= 1000).get._2

  private def indexedFibonacciFrom(n1: BigInt, n2: BigInt, index: Long): Stream[(BigInt, Long)] = {
    (n1, index) #:: indexedFibonacciFrom(n2, n1 + n2, index + 1)
  }
}
