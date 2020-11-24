package examples

import scala.util.Try

object ForComprehensionExample extends  App {

  // scala forloop is not really a for loop
  // it is a foreach, scala will convert your program into foreach

  for (i <- 1 to 5) {
    println(i)
  }

  println("----")

  (1 to 5).foreach(println)

  println("----")

  for {i <- 1 to 5} {
    println(i)
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)   // if it goes successful, I get something Int, Some value
    }catch {
      case _ =>  None // get nothing/ None value
    }
  }

  // for compression
      // OPtion, is the value is something, it takes the value and assing to result
  // will not enter the for loop body if teh result is None
  for { result <- toInt("100")} {
    println("Result", result)
  }

  def safeDiv (a : Int, b: Int): Try[Int] = Try (a/b)

  // if the return value is Success, means it enters to for block
  // if not (== Failure), then it doesn't enter into for code
  for { result <- safeDiv(10, 0)} {
    println("Try Result", result)
  }


}
