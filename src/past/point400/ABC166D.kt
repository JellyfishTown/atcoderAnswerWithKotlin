package past.point400

import kotlin.math.min

fun main(args: Array<String>) {
    val (a, b, n) = readLine()!!.split(' ').map(String::toLong)
    println(a * min(b - 1, n) / b)
}
