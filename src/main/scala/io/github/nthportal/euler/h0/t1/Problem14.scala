package io.github.nthportal.euler
package h0.t1

object Problem14 extends ProjectEulerProblem {
  override def apply(): Long = {
    (1 to 1000000)
      .map(i => (i.toLong, collatzStream(i).toList.size))
      .maxBy(_._2)._1
  }

  private def collatzStream(num: Long): Stream[Long] = {
    num match {
      case 1 => Stream.empty
      case n if n % 2 == 0 => n #:: collatzStream(n / 2)
      case n => n #:: collatzStream(3 * n + 1)
    }
  }
}
