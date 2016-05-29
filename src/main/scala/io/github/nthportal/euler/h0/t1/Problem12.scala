package io.github.nthportal.euler
package h0.t1

object Problem12 extends ProjectEulerProblem {
  override def apply(): Long = {
    val t = new TriangleNumbers()
    t.triangleNumbers
      .map(i => (i, numDivisors(i, t.naturals)))
      .find(_._2 > 500)
      .get._1
  }

  private def numDivisors(num: Long, naturals: Stream[Int]): Int = {
    val half = naturals
      .filter(num % _ == 0)
      .takeWhile(i => i * i < num)
      .toList
      .size
    val perfectSquare = if ({ val i = math.sqrt(num).toFloat; i * i == num }) 1 else 0
    half * 2 + perfectSquare
  }

  private class TriangleNumbers {
    val naturals: Stream[Int] = Stream.from(1)
    val triangleNumbers: Stream[Long] = naturals.map(i => naturals.take(i).map(_.toLong).sum)
  }
}
