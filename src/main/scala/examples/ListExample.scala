package examples

object ListExample extends  App {
  val list = List(1000, 100, 800, 200, 500)
  list.foreach(println)

  val list2 = List(10000, 2000)
  // ++ concat two list/ merge two list and store into list3
  val list3 = list ++ list2
  println("List3")
  list3.foreach(println)

  val list4 = list3.sorted
  println("List4 sorted")

  list4.foreach(println)

  val numbers = List(1, 2, 3, 4, 5, 6)
  //map is higher order function, is called as tranform values, return new collection
  val result = numbers.map ( n => n * n)
  println(result)

  // filter is higher function
  val evenOnly = result.filter (n => n % 2 == 0)
  val oddOnly = result.filter(n => n % 2 == 1)
  println("evenOnly", evenOnly)
  println("oddOnly", oddOnly)

  // returns a tuple2 (List[Int], List[Int),
  // _1 contains even number
  // _2 contains odd numbers
  val par = result.partition( n => n % 2 == 0)
  println("Even partition ", par._1)
  println("Odd partition ", par._2)
}
