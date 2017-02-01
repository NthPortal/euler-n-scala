package com.nthportal.euler

import org.scalatest.{FlatSpec, Matchers}

abstract class SimpleSpec extends FlatSpec with Matchers {

  implicit final class TestingProblem(private val problem: ProjectEulerProblem) {
    def shouldEvaluateTo(result: Long): Unit = {
      problem.getClass.getSimpleName.stripSuffix("$") should "evaluate the correct answer" in {
        problem() should be (result)
      }
    }
  }

}
