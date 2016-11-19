package com.nthportal.euler
package util

import scala.annotation.tailrec
import scala.collection.mutable

final class CachingStreamChecker(searchStream: Stream[Long]) {
  private val cache = mutable.HashSet[Long]()
  private var stream = searchStream

  @tailrec
  def isInStream(n: Long): Boolean = {
    if (n < stream.head) {
      n in cache
    } else {
      cache += stream.head
      stream = stream.tail
      isInStream(n)
    }
  }
}
