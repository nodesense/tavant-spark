package examples.formulas

//import examples.models.Temp
// import examples.models._ // ;; import all
import examples.models.{Temp, Light}

object Formula {
  implicit  def tempToDouble(temp: Temp) = temp.value
  implicit  def luminToDouble(light: Light) = light.lumin
}
