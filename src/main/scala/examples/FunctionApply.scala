package examples

object FunctionApply extends  App {
  // Function1[Int, Int]
  val power = (n: Int) => n * n

  val add = (a: Int, b: Int) => a + b

  // syntactial sugar, scala does a favor
  println(power(5)) // scala will convert power(5) code into power.apply(5)
  println(power.apply(5))

  println(add.apply(10, 20))

  // not done in practical usecase, this just demonstraiton how to create Function
  val sub: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a - b
  }

  // simply, easy, simple, recommended
  val sub2 = (a: Int, b: Int) => a - b



  println(sub(10, 50))
  println(sub2(10, 50))

}
