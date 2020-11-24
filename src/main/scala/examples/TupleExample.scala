package examples

object TupleExample  extends  App {
  // Tuple is a pairs of elements of different types possible
  // how different from list, List is collection of element with similar type

  // to create tuple
  // tuple has type for each element
  val t1 = (10, 20.0, "welcome")
  println(t1._1) // Int
  println(t1._2) // Double
  println(t1._3) // String

  println(t1)

  // just another way example
  val t2:Tuple2[String, Int] = ("Welcome", 28)

  println(t2)

  val t0: Unit = () // empty is nothing but Unit
  println(t0)

  // another way to create tuple of 2 elements / pair

  val avg = ("KA" -> 90)
  println("AVG " + avg)
  println(avg._1) // KA
  println(avg._2) // 90
}
