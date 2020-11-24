package examples

object CompanionObject extends  App {
  // if class name and object are same name in the same file,
  // it has been called as CompanionObject

  class Product(val name: String,
                val price: Double) {
    override def toString: String = s"$name, $price"
  }

  // object name and class name Product are same == companion object
  object Product {
    // apply function
    // works as a factory to produce object of type Product
    def apply(name: String, price: Double) = new Product(name, price)
  }


  // problem companion object resolves?
  // while creating object, we use new keyword, new Product()
  // new is statement, not an expression, not a function call
  // which is not compatible with functional programming [compose, andThen....]
  // we use companion to solve this issue.

  val p1 = new Product("iPhone", 75000)
  println(p1)
  // how not to use new keyword to create a object

  // flavor to use companion object
  // notice: no new keyword
  val p2 = Product.apply("Galaxy", 50000)
  println(p2)
  // flavor 2, final one, best one
  // notice: no new keyword
  val p3 = Product("Pixel 3", 30000) // this calls Product.apply automatically
  println(p3)
}
