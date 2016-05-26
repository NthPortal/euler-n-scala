package io.github.nthportal.euler
package p1

object Problem1 extends ProjectEulerProblem {
  override def apply(): Int = (1 to 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum
}
