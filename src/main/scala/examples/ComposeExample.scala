package examples

// andThen
// compose

// f(x)
// g(x)

// composition f(g(x))
// g(x) executed first
// the output of g(x) is passed as input to f(x) is executed next

// g(f(x)) - f is first, g is next

object ComposeExample extends  App {
   val tax = (n: Double) => n + n * 18.0/100
   val discount = (n: Double) => n - n * 10.0/100
   val coupon   = (n: Double) => n - n * 5.0 / 100

   println(tax(coupon(discount(100))))

   // andThen tax(coupon(discount(100)
  // andThen returns a function, that calls all the functions mentioned here
  // left to right f andThen g andThen h  h(g(f(x)))
   val andThenExample = discount andThen  coupon andThen tax;
   println("AndThen ", andThenExample(100))


    // compose
  // right to left tax(coupon(discount(100)
    val composeExample = tax compose coupon compose discount
    println("composeExample ", composeExample(100))


}
