package examples

object ClassExample3  extends  App {
  // inheritance
  // parent class
  class Order(val no: String, val amount: Double) {
  }

  // child class
  class RetailOrder (no: String, // note, no var/val, constructor arg
                     amount: Double, // note, no var/val, constructor arg
                     val retailerCode: String ) extends  Order(no, amount) {

    override def toString: String = s"RetailOrder($no, $amount, $retailerCode)"
  }

  val ro1 = new RetailOrder("100", 1000, "232")
  println(ro1)

}
