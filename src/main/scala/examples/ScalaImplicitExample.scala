package examples

import examples.models._ // import Light, Temp , others

// import tempToDouble, loghtToDouble implicit functions
// applicable for whole file
import examples.formulas.Formula._

object ScalaImplicitExample extends  App {
  // scope
  {
    // use implicit for type conversion, you can only one type , no ambiguity
    implicit def doubleToInt(d: Double) = {
      println("doubleToInt called")
      d.toInt
    }
    val x: Int = 42.0 // shall call doubleToInt automatically
    println("X ", x)
    val y: Int = 42.0  // shall call doubleToInt automatically
  }

  // check if implict works outside scope or not
  // NO, it doesn't, implicit is specific to scope
  // compilation error
  //val y: Int = 42.0;

  {
    //example 2:
    //variable name doesn't matter,
    // the type Int
    // implicit: compiler automatically picks the values based on type
    implicit  val i : Int = 5 // variale is not a issue, only type
    implicit  val j : Long = 3
    def add(a: Int)(implicit b:Int) = a + b
    def sub(a: Int) (implicit  x: Long) = a - x
    println("add 10", add(10))
    println("Sub ", sub(10)) // 10 -3
  }

  val temp1 = Temp(35)
  val light1 = Light(1900)

  val t : Double = temp1 // calls implicit tempToDouble
  val l1 : Double = light1 // calls implicit lightToDouble
  println("t " + t)
  println("l1 " + l1)
}
