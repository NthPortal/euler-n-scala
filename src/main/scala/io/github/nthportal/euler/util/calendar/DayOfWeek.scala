package io.github.nthportal.euler.util.calendar

sealed trait DayOfWeek {
  final def name: String = {
    val n = getClass.getSimpleName
    n.substring(0, n.length - 1)
  }

  def nextDay: DayOfWeek

  override def toString: String = name
}

object DayOfWeek {

  object Sunday extends DayOfWeek {
    override def nextDay: DayOfWeek = Monday
  }

  object Monday extends DayOfWeek {
    override def nextDay: DayOfWeek = Tuesday
  }

  object Tuesday extends DayOfWeek {
    override def nextDay: DayOfWeek = Wednesday
  }

  object Wednesday extends DayOfWeek {
    override def nextDay: DayOfWeek = Thursday
  }

  object Thursday extends DayOfWeek {
    override def nextDay: DayOfWeek = Friday
  }

  object Friday extends DayOfWeek {
    override def nextDay: DayOfWeek = Saturday
  }

  object Saturday extends DayOfWeek {
    override def nextDay: DayOfWeek = Sunday
  }

}
