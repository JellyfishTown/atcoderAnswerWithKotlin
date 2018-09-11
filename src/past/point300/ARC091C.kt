package past.point300

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    println(Math.abs((n - 2) * (m - 2)))
}

