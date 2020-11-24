package examples

object CaseClassExample extends  App {
    // Class, Object - discussed
    // Companion Object - class name and object name are same and use of apply function to create object
    // case class - a class, with companion nature. plenty of them in scala code

    // by default case class members are immutable
    // will have toString implemented
    // will have companion object, with apply method
    // 95% of spark code shall have case classes
    // to represent a fact/record
    // immutable by default
    case class Product(name: String, price: Double)

    // no need to use new keyword, eventhough it works
    val p1 = new Product("iphone", 75000)
    println(p1)

    // final and best usage
    //   no new keyword, case class has apply function inbuilt
   val p2 = Product("Galaxy", 50000)
   println(p2)
}
