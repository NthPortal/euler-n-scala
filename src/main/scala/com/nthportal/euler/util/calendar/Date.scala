package com.nthportal.euler.util.calendar

import java.util.Objects

case class Date(month: Month, day: Int, dayOfWeek: DayOfWeek) {
  Objects.requireNonNull(month)
  Objects.requireNonNull(dayOfWeek)
  if (day <= 0 || day > month.days) throw new IllegalArgumentException("Invalid day '" + day + "' for month: " + month)

  def year: Int = month.year

  def nextDay: Date = {
    if (day == month.days) Date(month.nextMonth, 1, dayOfWeek.nextDay)
    else Date(month, day + 1, dayOfWeek.nextDay)
  }

  override def toString: String = month + " " + day + ", " + dayOfWeek
}
