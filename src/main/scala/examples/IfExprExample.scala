package examples

object IfExprExample extends  App {
  // val n is a declaration
  // 10 * 20 is an expression
  // val n = 10 * 20 is called a statement
  val n = 10 * 20 // compute and assign to n, assignment, not return value

  // Java, C, C++ , C# if is a statement, a statement doesn't return value
  // in Scala, if is an expression, returns a value

  val m = 11
  val result : String = m % 2 match {
    case 0 => "Even" // The value Even is returned from match statement
    case 1 => "Odd" // Odd is returned
  }

  println("result ", result)

  // if either returns Even or Odd
  val result2 = if (m % 2 == 0) "Even" else "Odd"
  println("result2", result2)

  // For loop with Yield is an expression, returns the value, of type Collection
  // get numbers from 1 to 10
  val numbers = for (i <- 1 to 10)  yield i
  println(numbers)

  val numbersMul2 = for (i <- 1 to 10) yield i * 2
  println(numbersMul2)

  // return only odd numbers
  val oddNumbers = for ( i <- 1 to 10 if i % 2 == 1) yield i
  println(oddNumbers)

}
