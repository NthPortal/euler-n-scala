package com.nthportal.euler.h0

import com.nthportal.euler.h0.t0._
import org.junit.Test
import org.scalatest.junit.JUnitSuite

class P00xTests extends JUnitSuite {
  @Test
  def Problem1Test(): Unit = assert(Problem1() == 233168)

  @Test
  def Problem2Test(): Unit = assert(Problem2() == 4613732)

  @Test
  def Problem3Test(): Unit = assert(Problem3() == 6857)

  @Test
  def Problem4Test(): Unit = assert(Problem4() == 906609)

  @Test
  def problem5Test(): Unit = assert(Problem5() == 232792560)

  @Test
  def problem6Test(): Unit = assert(Problem6() == 25164150)

  @Test
  def problem7Test(): Unit = assert(Problem7() == 104743)

  @Test
  def problem8Test(): Unit = assert(Problem8() == 23514624000L)

  @Test
  def problem9Test(): Unit = assert(Problem9() == 31875000)
}
