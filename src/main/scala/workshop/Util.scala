package workshop

object Util {
  val INPUT_DIRECTORY = "file:///Users/krish/workshops/scala-workshop/inputs"
  val OUTPUT_DIRECTORY = "file:///Users/krish/workshops/scala-workshop/outputs"

  def getInputPath(fileName: String) = INPUT_DIRECTORY + "/" + fileName
  def getOutputPath(fileName: String) = OUTPUT_DIRECTORY + "/" + fileName
}

