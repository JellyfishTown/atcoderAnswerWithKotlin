package past.point400

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    println(calcXor(a - 1) xor calcXor(b))
}

fun calcXor(x: Long) = when (x % 4) {
    0L -> x
    1L -> 1
    2L -> x + 1
    else -> 0
}
