package point300


fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    when {
        2 * n > m -> println(m / 2)
        else -> println((m - 2 * n) / 4 + n)
    }
}
