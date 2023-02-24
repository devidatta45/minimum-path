package com.suprnation

import scala.io.Source

object MinimumPath extends App {
  def helper(A: Array[Array[Int]], i: Int, j: Int): Int = {
    if (i == A.length) return 0
    val result = A(i)(j) + Math.min(helper(A, i + 1, j), helper(A, i + 1, j + 1))
    result
  }

  def minSumPath(A: Array[Array[Int]]): Int = helper(A, 0, 0)

  val source = Source.fromFile("sample.txt")
  val lines = source.getLines().toArray
  val triangle = lines.map { line =>
    line.split(" ").map(_.toInt)
  }

  println(minSumPath(triangle))
}


