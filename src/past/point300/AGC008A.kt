fun main(args: Array<String>) {
    val (x, y) = readLine()!!.split(" ").map(String::toLong)
    var m = Long.MAX_VALUE
    m = calc008(y - x, m)
    m = calc008(x + y + 1, m)
    m = calc008(-x - y + 1, m)
    m = calc008(x - y + 2, m)
    println(m)
}

fun calc008(a: Long, b: Long): Long {
    return if (a < 0) b else Math.min(a, b)
}

