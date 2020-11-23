package examples

object WhileLoop extends  App {
  var i = 0

  while (i < 10) {
    println(i)
    // i++, postfix will not work
    // ++i prefix will not work
    i += 1
  }

  var j = 0
  do {
      println(j)
     j = j + 1
  } while ( j < 10)

}
