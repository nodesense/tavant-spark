package examples

object FunctionExample extends  App {
    // Method used within classes, object - using def keyword
      // In Java, Method is a member function, which itself is not an object
      //a method cannot be passed or returend from anotehr method
    // Function ** most often in big data
    // Functions are object in scala - using =>
      // assign function to variable
      // return a function from another function
      // pass function as an argument
      // in Java, functions are similar to lambda

  // METHOD - def
  def powerN (n: Int) = n * n
  /// ERROR, cannot assign method to another variable
  // val powerM = powerN // error

  // FUNCTION is an object
  // (n: Int) => n * n
  // (n: Int) is a function declaration
  // n * n is a function body
  // single line function
  val power = (n: Int) => n * n
  // We can assign
  val powerM = power

  println(power(3))
  println(powerM(5))

  // 3 minute time, implement add function => which takes a and b adn return a + b
  val add = (a : Int, b: Int ) => a + b
  // 2 minutes, return Odd or even for given n
  val oddOrEven = (n: Int) => if (n % 2 == 0) "Even" else "Odd"

  val sumOfN = (n: Int) => {
    var s = 0;
    for (i <- 1 to n ) {
      s += i
    }
    s
  }

  println(add(10, 20))
  println(oddOrEven(10))
  println(sumOfN(6))

}
