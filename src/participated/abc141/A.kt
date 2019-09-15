package participated.abc141

fun main(args: Array<String>) {
    val s = readLine()!!
    when (s) {
        "Sunny" -> println("Cloudy")
        "Cloudy" -> println("Rainy")
        "Rainy" -> println("Sunny")
    }
}