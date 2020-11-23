package examples

object ValueExample extends  App {
  // value, immutable, cannot be changed
  val i: Int = 10 // 4 bytes
  // type infererce, compiler derive type from expression, 20 means int
  val j = 20
  val name: String = "Scala"
  val name2 = "Scala"
  val result: Boolean = true // 1 byte
  val result2 = false

  val d: Double = 3.14 // 8 bytes
  val f: Float = 3.14f // 4 bytes

  val b: Byte = 200.toByte // 1 byte
  val l: Long = 1234412312 // 8 bytes


  println(i, j)

  // error, VALUE CANNOT BE CHANGED
  // i = 10 // compiler error
  // j = 5  // compiler error
}
