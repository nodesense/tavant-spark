package examples.models

object FuncWithVariableArgs extends  App {
  def printNames(names: String*) = {
    println("Names length " + names.length)
    println("Names", names)
  }

  def sum (n: Int*) = {
    var s = 0
    for (k <- n) {
      s += k
    }
    s
  }

  printNames("Scala", "Spark", "java")
  println(sum())
  println(sum(10))

  println(sum(10, 20, 30))

  val numbers: List[Int] = List(10, 20, 50, 60)
  // sum cannot accept array or list or seq
  // sum(numbers) // error
  // how to extract the values from the list and pass to sum function
  sum(numbers:_*) // this will work, returns 140


}
