package examples

object CurryFunctionExample extends  App {
  // curry function
  // closure

  // curry function
  // a function that returns another function is called curry function
  def getFunc() = {
    println("getFunc callled")
    val sayHello = (name: String) => {
      println("Hellooooo " + name)
    }
    println("returning say hello function")
    sayHello
  }

  // func1 is nothing but sayHello
  val func1 = getFunc()
  func1("Scala") // calling sayHello

  //getFunc() returns a function, then we call returned function
  getFunc()("Spark") // calling sayHello

  //TODO: create a method called math
  // math return a function called add that accept a and b both are ints,
  //  function add does a + b and return teh result
  // then you add function with add(1, 3) add(10, 40)
  def math()  = {
    val add = (a: Int, b: Int) => a + b
    add
  }

  def addFunc = math()
  println(addFunc(10, 20))

  //closure
  // function state


}
