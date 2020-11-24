package examples

object ExceptionExample extends  App {
   // exception cause the program to halt
  // handle the exception
  // try...catch -- catch the exception
  // handling may be different

   try {
     val result = 42 / 0;
   } catch {
     case e: ArithmeticException =>
       // capture and suppress the error
       println("Error occured " + e)

     case _ => println("unknown error")
   } finally {
     // called whether exception happen or not
     // clean up memory/resources
     println("Finally called")
   }
}
