package past.point200

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(" ").map(String::toInt)
    val range = 1..n
    println(range.filter { sumKeta(it) in a..b }.sum())
}

fun sumKeta(num: Int): Int {
    val str = num.toString()
    var sum = 0
    str.forEach { sum += it.toString().toInt() }
    return sum
}