package examples

object ParameterGroup extends  App {
  def add(a: Int, b: Int, c: Int) = a + b + c
  //parameter group
  // sum(a: Int) returns a function b
  // sum(a: Int) (b:Int) returns another function C
  // sum(a:Int) (b:Int) (c:Int) returns a + b + c
  def sum(a: Int) (b:Int) (c: Int) = a + b + c

  // normal function
  println(add(10,20, 30))

  // parameter group functions
  // returns a function wiht a = 10
  // sum(a: Int)
  // a = 10
  // need to convert method sum to function
  val add10 = (sum _) (10)
  // reuse add10 in many places
  //  sum(a: Int) (b:Int), a = 10, b = 20
  val add10With20 = add10(20)
  // a = 10, b= 20, c = 30
  val result = add10With20(30)
  println("result ", result) // 10 + 20 + 30
  println(add10With20(100))

  def tag(name: String) (children: String) = s"<$name>$children</$name>"

  // convert method into function
  def tagF = tag _

  def div = tagF("div")
  def table = tagF("table")
  def span = tagF("span")

  println(div(span("My name is scala")))
  println(div(table(span("My name is scala"))))


}
