package examples

import com.sun.org.apache.xpath.internal.functions.FunctionDef1Arg

object FunctionNExample extends  App {

  // => scala convert your function into FunctionN automatically

  // args to hello func: no arg
  // return value: Unit
  val hello = () => println("Hello")

  // args : message: String
  // return value: Unit
  val greeting = (message: String) => println(message)

  // arg: int
  // return value: int
  val power = (n: Int) => n * n

  // args, a and b
  // return value: Int
  val add = (a: Int, b: Int) => a + b

  // 0 arg
  // return Unit
  val hello2 : Function0[Unit] = hello
//                         // argtype, return arg
  val greeting2 : Function1[String, Unit] = greeting
  val power2 : Function1[Int, Int] = power
  val add2: Function2[Int, Int, Int] = add
  // upto Function22
  hello()
  hello2()

  greeting("Good monring")
  greeting2("Good monring")


}
