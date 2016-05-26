package io.github.nthportal.euler
package h0.t0

object Problem5 extends ProjectEulerProblem {
  override def apply(): Long = {
    (1 to 20)
      .map(Util.primeFactors(_).toList)
      .map(_.groupBy(identity).mapValues(_.size))
      .fold(Map()) { (m1, m2) =>
        (m1.toSeq ++ m2.toSeq)
          .groupBy(_._1)
          .mapValues(_.map(_._2).max)
      }
      .map(kv => math.pow(kv._1, kv._2).toLong)
      .product
  }
}
