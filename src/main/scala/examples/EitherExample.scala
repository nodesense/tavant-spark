package examples

object EitherExample extends  App {
  // Either - this or that // NOT LIKE SOMETHING OR NOTHING
  // Either - LEFT and RIGHT
                            // Left, Right
  def toInt(s: String): Either[Exception, Int] = {
    try {
      // convention Right means good value
      Right(s.toInt)
    }
    catch {
      case e: Exception =>   Left(e)  // conventionally Left means bad value
    }
  }

  val result = toInt("#,.") // toInt("100") // toInt("#,.")
  println("result ", result)

  if (result.isRight) {
    println("We got result ", result.right.get)
  }

  if (result.isLeft) {
    println("Error is ", result.left.get)
  }

}
