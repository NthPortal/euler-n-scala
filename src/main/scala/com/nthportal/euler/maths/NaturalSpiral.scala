package com.nthportal.euler.maths

object NaturalSpiral {
  def diagonalValues: Stream[Long] = 1 #:: cornerStream(1, 2).flatten

  def groupedCorners: Stream[Stream[Long]] = cornerStream(1, 2)

  private def cornerStream(prevCorner: Long, dist: Long): Stream[Stream[Long]] = {
    nextCorners(prevCorner, dist) #:: cornerStream(prevCorner + (4 * dist), dist + 2)
  }

  private def nextCorners(prevCorner: Long, dist: Long): Stream[Long] = Stream.iterate(prevCorner + dist, 4) {_ + dist}
}
