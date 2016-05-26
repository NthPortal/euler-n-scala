package io.github.nthportal.euler.p1

object Problem1 extends (() => Int) { def apply(): Int = (1 to 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum }
