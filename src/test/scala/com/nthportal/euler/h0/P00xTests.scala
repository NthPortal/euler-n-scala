package com.nthportal.euler.h0

import com.nthportal.euler.h0.t0._
import org.junit.Assert._
import org.junit.Test
import org.scalatest.junit.JUnitSuite

class P00xTests extends JUnitSuite {
  @Test
  def Problem1Test(): Unit = assertEquals(233168, Problem1())

  @Test
  def Problem2Test(): Unit = assertEquals(4613732, Problem2())

  @Test
  def Problem3Test(): Unit = assertEquals(6857, Problem3())

  @Test
  def Problem4Test(): Unit = assertEquals(906609, Problem4())

  @Test
  def problem5Test(): Unit = assertEquals(232792560, Problem5())

  @Test
  def problem6Test(): Unit = assertEquals(25164150, Problem6())

  @Test
  def problem7Test(): Unit = assertEquals(104743, Problem7())

  @Test
  def problem8Test(): Unit = assertEquals(23514624000L, Problem8())

  @Test
  def problem9Test(): Unit = assertEquals(31875000, Problem9())
}
