package examples

// Singleton, only one instance
// Object itself is an instance, we cannot create again another instance
object ObjectExample extends  App {

  object Logger {
    // object constructor , executed only one to initialize on the first use
    println("Logger initialization")
    var _logLevel: Int = 0
    def setLogLevel(l: Int) = _logLevel = l
    override def toString: String = s"Logger (logLevel ${_logLevel})"
  }

  println("Running ")
  Logger // first time, we use Logger, it calls the object constructor, initialize object
  Logger // second time, it won't call constructor again, already initialized

  println(Logger) ;// calls toString
  Logger.setLogLevel(5)
  println(Logger)
}
