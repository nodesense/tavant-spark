package examples

object ForLoop extends  App {
  for (i <- 1 to 10) {
    println(i, i * 2)
  }

  println("--- incr by 5 ")

  for (i <- 0 to 50 by 5) {
    println(i)
  }
}
