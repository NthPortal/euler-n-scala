package io.github.nthportal.euler
package p2

object Problem2 extends ProjectEulerProblem {
  override def apply(): Int = {
    fibonacciFrom(1, 1)
      .takeWhile(_ < 4000000)
      .filter(_ % 2 == 0)
      .sum
  }

  private def fibonacciFrom(n1: Int, n2: Int): Stream[Int] = n1 #:: fibonacciFrom(n2, n1 + n2)
}
