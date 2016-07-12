package io.github.nthportal.euler
package h0.t3

object Problem39 extends ProjectEulerProblem {
  override def apply(): Long = {
    {
      for {
        p <- 3 to 1000
        solutions = for {
          hyp <- (p / 3) to (p / 2)
          remaining = p - hyp
          l1 <- (remaining / 2) to remaining
          l2 = remaining - l1
          if l1 > 0 && l2 > 0
          if l2 <= l1 && l1 < hyp  // Just in case
          if (l1 ** 2) + (l2 ** 2) == hyp ** 2
        } yield (l1, l2, hyp)
      } yield (solutions.length, p)
    }.maxBy(_._1)
      ._2
  }
}
