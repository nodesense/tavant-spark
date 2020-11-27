package examples

// for Closure, refer ClosureExample2
object ClosureExample extends  App {
  // Scope
  // Visibility
  // outter scope
  val a = 10

  {
    // create scope, visiblity restricted within the scope
    val b = 20
    // a is visible from outer scope here
    val c = a + b
    println("C is ", c)
    // both b and c are not accessible outside the scope

    {
      // a, b, c visible here, nested scope
      println(a, b, c)
    }
  }

  println("A ", a)
  //println("B ", b) // error, b not accessible
  //println("C", c)// error, c not accessible

}
