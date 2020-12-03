package examples

import java.sql.DriverManager
import java.sql.Connection

object JDBCExample extends  App {

  val driver = "org.apache.hive.jdbc.HiveDriver"
  val url = "jdbc:hive2://95.217.219.44:10000/default"
  val username = ""
  val password = ""

  // there's probably a better way to do this
  var connection:Connection = null

  try {
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    // create the statement, and run the select query
    val statement = connection.createStatement()
    statement.executeQuery("CREATE DATABASE userdb");

    val resultSet = statement.executeQuery("SELECT host, user FROM user")
    while ( resultSet.next() ) {
      val host = resultSet.getString("host")
      val user = resultSet.getString("user")
      println("host, user = " + host + ", " + user)
    }
  } catch {
    case e => e.printStackTrace
  }
  connection.close()

}
