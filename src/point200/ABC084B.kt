package point200

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)
    val s = readLine()!!
    val regex = Regex("^[0-9]{$a}-[0-9]{$b}\$")
    if (regex.matches(s)) {
        println("Yes")
    } else {
        println("No")
    }
}

