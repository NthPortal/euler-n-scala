package io.github.nthportal.euler
package p2

object Problem2 extends ProjectEulerProblem {
  override def apply(): Int = {
    Stream.iterate[(Int, Int)]((1, 1)) { t => (t._2, t._1 + t._2) }
      .takeWhile(_._2 < 4000000)
      .map(_._2)
      .filter(_ % 2 == 0)
      .sum
  }
}
