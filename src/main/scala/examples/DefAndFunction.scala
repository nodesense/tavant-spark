package examples

object DefAndFunction extends  App {

  // how to convert a method (def) to a functionN
  def power(n: Int) = n * n

  // methodName _ will create a function out of method
  // power1 and power11 are Function1[Int, Int]
  val power1 = power _
  val power11: Function1[Int, Int] = power _

  // power.apply(10) // will not work, def is not a function
  power1.apply(10) // work, the method is converted to function using _
  power11(10)
  power11.apply(10)

  // composition and andThen possible
  println((power1 compose power1) (2)) // output 16
}
