package workshop
object Util {
  val INPUT_DIRECTORY = "file:///home/krish/tavant-spark/inputs"
  val OUTPUT_DIRECTORY = "file:///home/krish/tavant-spark/outputs"

  def getInputPath(fileName: String) = INPUT_DIRECTORY + "/" + fileName
  def getOutputPath(fileName: String) = OUTPUT_DIRECTORY + "/" + fileName
}

