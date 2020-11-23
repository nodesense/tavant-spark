package examples

object  MethodExample extends  App {
  // methods
  def power(n: Int): Int = n * n
  // return type is not mentioned, scala inference the type
  def add(a: Int, b: Int) = a + b

  def sub(a: Int, b: Int) = {
    // multi line block
    // the last evaluated expression is returned by default, no need of return keyword
    // not exactly last line of code
    a - b
  }

  def oddOrEven(n: Int) = {
    if (n % 2 == 0)
        "Even" // return
    else "Odd" // or return
  }

  def sum(n: Int) = {
    var s = 0;
    for (i <- 0 to n) {
      s += i
    }

    s // s value is returned
  }

  // recursion
  // calling same function again and again
  def fact(n: Int): Int = {
    if (n == 1)  1
    else n * fact(n - 1)
  }

  // homework
  // gcd

  val p = power(3)
  println(p)
  println(add(10, 20))
  println(sub(40, 30))

  println(oddOrEven(100))
  println(oddOrEven(101))

  println(sum(5))

  println("fact(5)", fact(5))
}
