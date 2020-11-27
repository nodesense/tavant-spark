package examples

object ClosureExample2 extends  App {
  // Closure, curry, visibility and state
  // seq generator 0, 1, 2, 3...... ::: 100, 110, 120
  def seq(seed: Int, step: Int = 1) = {
    // value of n remains even after the function exit
    // ref of incr maintained outside teh function block
    // n is encapsulated so that n cannot be modified outside
    // function state, value n is maintained
    var n = seed // outter scope, visible inside incr function

    val incr = () => {
      val r = n // n is visible
      n += step
      r // return value
    }

    incr// curry
  }

  val incr0By1 = seq(0)
  val incr100By10 = seq(100)

  println(incr0By1())
  println(incr0By1())
  println(incr0By1())

  println(incr100By10())
  println(incr100By10())
  println(incr100By10())

}
