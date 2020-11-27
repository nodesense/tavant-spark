package examples

object PartialFunctionExample extends  App {
  // function  -- unit of code, accept parameters adn return values
  // partial function -- unit of code, accept parameter and return values
  // partial function is not complete function
  // partial function doesn't complies to all the parameters

  def div(a: Int) = {
     42 / a
  }

  println(div(2)) // 21
  // println(div(0)) // exception
  // why exception? because the input is wrong
  // the div is not complete function when a is 0

  // solution approach 1 is check the parameter and do the computation
  // the function is already called, then only we check for the result

  // SOLUTION: Check whether the function support input arg and then call the function

  // SOLUTION: How to create partial function
                                  // [input, return value]
  val divide = new PartialFunction[Int, Int] {
                                  def apply(x: Int) = 42 / x
                                  override def isDefinedAt(x: Int): Boolean =  x != 0
                }

  println("is 2 defined ? " + divide.isDefinedAt(2))
  println("is 0 defined ? " + divide.isDefinedAt(0))

  if (divide.isDefinedAt(2)) {
    println("divide(2) ", divide(2) )
  }

  // Partial function with simplified code using Scala case
  // isDefinedAt function automatically written by scala based on case classes
  val divide2: PartialFunction[Int, Double] = {
    case x: Int if x != 0 => 42.0 / x
      // you can write many cases
  }

  println("is 2 defined ? " + divide2.isDefinedAt(2))
  println("is 0 defined ? " + divide2.isDefinedAt(0))

  if (divide2.isDefinedAt(2)) {
    println("divide2(2)", divide2(2))
  }

  val list = List(100, 200,  400, 500, 0, 600);
  // divide 42 by 100, then 200, 0, 400
  // cause exception due to divide by 0
  // map function, filter functions doesn't respect partial function
  //val result = list.map(divide2)
  //println("div 42 by", result)

  // collect respect partial function, it calls isDefinedAt before calling the function
  // it skipped 0 value
  val result = list.collect(divide2)
  println("div 42 by", result)

}
