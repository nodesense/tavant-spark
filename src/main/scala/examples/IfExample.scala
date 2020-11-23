package examples

object IfExample extends  App {
  val n = 10

  if (n % 2 == 0) {
    println(n, " even")
  }
  else {
    println(n, " odd")
  }

}
