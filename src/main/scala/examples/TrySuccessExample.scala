package examples

import scala.util.{Try, Success, Failure}

object TrySuccessExample extends  App {
  def safeDiv (a : Int, b: Int): Try[Int] = Try (a/b)

  val x = safeDiv(10, 0) //
  if (x.isSuccess) {
    println("Successful", x.get)
  }

  if (x.isFailure) {
    println("Failed ", x.failed)
  }
}
