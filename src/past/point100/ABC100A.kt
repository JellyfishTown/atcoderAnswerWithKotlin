fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)
    if (a > 8 || b > 8) {
        println(":(")
    } else {
        println("Yay!")
    }
}

