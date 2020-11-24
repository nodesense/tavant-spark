package examples

object  OptionExample extends  App {

  // getTicket () Ticket or nothing
   // Either - Window / Aisle seat get either one

  //Option - Can I attend the class - Option
  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)   // if it goes successful, I get something Int, Some value
    }catch {
      case _ =>  None // get nothing/ None value
    }
  }

  // Option, we don't have the exception that is really happend

  val result: Option[Int] = toInt("100"); // toInt("#.")

  // whether we have result or not
  if (result.isDefined) { // no error, we got result
    println("result is ", result.get)
  }

  if (result.isEmpty) { // error, should not call get
    println("Error, no value")
  }

  println(toInt("100"))
  println(toInt("#.,"))


}
