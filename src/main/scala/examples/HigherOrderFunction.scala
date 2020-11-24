package examples

object HigherOrderFunction extends  App {
  // functional pattern
  // a function that accept another function as arg is known as higher order function

  def identity(n: Int) = n
  def sq(n: Int) = n * n
  def cube (n: Int) : Int = n * n * n

  // f: is a function1[Int, Int], n is int
  // math is called higher order function
  val math = ( f: Int => Int, n: Int) => f(n)
  //identity _ converts method to function
  println(math (identity _, 10));
  println(math (sq _, 10));
  println(math (cube _, 10));



  val math2 = ( f: (Int, Int) => Int, a: Int, b: Int) => f(a, b)
  def add (a: Int, b: Int) = a + b
  println(math2( (add _), 10, 20))

}
