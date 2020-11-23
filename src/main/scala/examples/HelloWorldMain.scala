package examples

// explicit main, without App
object HelloWorldMain {
  // Unit means void, doesn't return value
  def main(args: Array[String]): Unit  = {
    println("Hello World")
    println("length " + args.length)
    println(args(0), args(1))
  }
}
