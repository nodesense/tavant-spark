package examples

object ClassExample2 extends  App {
  class Order(val no: String, val amount: Double) {
    // Used to get println text
    // override def toString: String = "#Order " + no + " " + amount

    // string template in scala
    // s"$variableName", useful for string formation
    override def toString = s"#Order($no, $amount)"
  }

  val order1 = new Order("1001", 999)
  println(order1)                   // calls order1.toString

    val order2 = new Order("4001", 1999)
    println(order2)
}
