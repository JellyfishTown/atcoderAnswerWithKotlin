package point200

fun main(args: Array<String>) {
    val (n, m, x) = readLine()!!.split(" ").map(String::toInt)
    val a = readLine()!!.split(" ").map(String::toInt)
    val left = a.filter { it < x }.size
    val right = a.filter { it > x }.size
    println(Math.min(right, left))
}