fun doSomething(a: Int, b: Int) = a > b

class EntertainmentDevice(val name: String, var releaseYear: Int) {
  val isAfter2000: Boolean
    get() = releaseYear >= 2000
}

typealias MyCustomPredicate = (Int, Int) -> Boolean

fun main() {
  val p = ::doSomething
  println(p(10, 20))

  val p2: (Int, Int) -> Boolean = ::doSomething
  println(p2(10, 20))

  val p3: MyCustomPredicate = ::doSomething
}
