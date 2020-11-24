package examples

object MatchCaseExample extends  App {
  // if - true part
  // else - else part
  // nested if else

  // match and case expression, support multiple conditions, more advanced

  val n = 11

  n % 2 match {
    case 0 => println("Even Number")
    case 1 => println("Odd Number")
  }

  val m = 6
  // | means pipe
  m match {
      // check with multiple matches
    case 0 | 2 | 4 | 6 | 8 => println("m is Even Number")
    case 1 | 3 | 5 | 7 | 9 => println("m Odd")
  }

  val cmd = "start"
  cmd match {
    case "start" | "run" => println ("starting")
    case "stop" => println("stopping")
      // default case, if none of the match above not matched, case _ shall be executed
    case _ => println("command not found")
  }

  // case with guard
  def rangeCheck(n: Int) = n match {
    case x: Int if (x < 16)  => println("Too chil")
    case x: Int if (x >= 17 && x <= 26) => println("Normal")
    case x: Int if (x >= 27) => println("Too hot")
  }

  rangeCheck(10)
  rangeCheck(20)
  rangeCheck(30)

}
