package examples

object VariableExample extends  App {
  // variable, value can be changed
  var i = 10
  var j: Int = 20

  // variable can be changed
  i = 100
  j = 200

  i += 20
  println(i, j )
}
