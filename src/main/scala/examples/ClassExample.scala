package examples

object ClassExample extends  App {
    // no is a value type/immutable, public scope
    class Invoice(val no: String,
                  private val amount: Double,
                  protected val discount: Double) {

       // public scope
       def getAmount() = amount

       def getDiscount() = {
         discount
       }

      def netAmount() = {
        amount - (amount * discount/100.0)
      }

    }

    // obj/instance for the class
     val inv1 = new Invoice("INV#001", 9999.99, 20)
     println("inv1 " + inv1.no) // access public

   // inv1.amount  // error, cannot access private
    println("Amount " + inv1.getAmount())

    println("Net " + inv1.netAmount())



}
