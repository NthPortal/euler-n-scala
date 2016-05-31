package io.github.nthportal.euler
package h0.t1

import io.github.nthportal.euler.util.calendar.Date
import io.github.nthportal.euler.util.calendar.DayOfWeek.{Monday, Sunday}
import io.github.nthportal.euler.util.calendar.Month.January

object Problem19 extends ProjectEulerProblem {
  private val startingDate = Date(new January(1900), 1, Monday)

  override def apply(): Long = {
    dateStream(startingDate)
      .dropWhile(_.year < 1901)
      .takeWhile(_.year < 2001)
      .count(d => d.day == 1 && d.dayOfWeek == Sunday)
  }

  private def dateStream(date: Date): Stream[Date] = date #:: dateStream(date.nextDay)
}
