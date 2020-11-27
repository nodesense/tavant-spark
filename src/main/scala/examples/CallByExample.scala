package examples

object CallByExample extends  App {

  def nano() = {
    println("Nano called")
    System.currentTimeMillis()
  }

  def delayed(t: Long) = {
    println("Delayed called")
    val k = t
    println("K is ", k)
  }

  // call by name
  // lazy execution of the code
  // t: => Long represent code block single or block of codes
  // t: => Long is basically a block or line of code that returns Long type, no input
  def delayedByName(t: => Long) = {
    println("Delayed called")
    val k = t
    println("K is ", k)
  }

  // nano() is called,
  // output nano() is passed as input t to delayed function
  delayed(nano())
  println("------by name -----")
  // nano() is not executed immediate, instead it is passed as block into delayedByName
  delayedByName(nano())
  println("------by name /block -----")
  delayedByName({
    println("Block called")
    10000
  })

  def ifElse(predicate: => Boolean, ifPart: => Unit, elsePart: => Unit) = {
    if (predicate) ifPart else elsePart
  }

  ifElse ({ 10 > 5}, { println("Succcess")}, { println("Failure")})
  ifElse ({ 10 > 5},   println("Succcess"),  println("Failure"))
  ifElse ({ 10 < 5}, println("Succcess"), println("Failure"))

}
