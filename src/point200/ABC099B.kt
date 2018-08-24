package point200

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    val l = (1..999).filter { it < b - a }.sum()
    println(l - a)
}