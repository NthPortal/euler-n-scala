package io.github.nthportal.euler.util.calendar

sealed trait Month {
  final def name: String = getClass.getSimpleName

  def year: Int

  def days: Int

  def nextMonth: Month

  override def toString: String = year + " " + name

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Month => this.tupled equals that.tupled
      case _ => false
    }
  }

  override def hashCode(): Int = tupled.hashCode

  private def tupled = (name, year, days)
}

object Month {

  abstract class AbstractMonth(yr: Int) extends Month {
    final def year: Int = yr
  }

  abstract class ThirtyDayMonth(yr: Int) extends AbstractMonth(yr) {
    final def days: Int = 30
  }

  abstract class ThirtyOneDayMonth(yr: Int) extends AbstractMonth(yr) {
    final def days: Int = 31
  }

  class January(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new February(year)
  }

  class February(yr: Int) extends AbstractMonth(yr) {
    override def nextMonth: Month = new March(year)

    override def days: Int = {
      if (year % 4 == 0) 29
      else 28
    }
  }

  class March(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new April(year)
  }

  class April(yr: Int) extends ThirtyDayMonth(yr) {
    override def nextMonth: Month = new May(year)
  }

  class May(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new June(year)
  }

  class June(yr: Int) extends ThirtyDayMonth(yr) {
    override def nextMonth: Month = new July(year)
  }

  class July(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new August(year)
  }

  class August(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new September(year)
  }

  class September(yr: Int) extends ThirtyDayMonth(yr) {
    override def nextMonth: Month = new October(year)
  }

  class October(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new November(year)
  }

  class November(yr: Int) extends ThirtyDayMonth(yr) {
    override def nextMonth: Month = new December(year)
  }

  class December(yr: Int) extends ThirtyOneDayMonth(yr) {
    override def nextMonth: Month = new January(year + 1)
  }

}
