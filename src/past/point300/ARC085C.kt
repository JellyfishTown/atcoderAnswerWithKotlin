package past.point300

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    println((m * 1900 + (n - m) * 100) * Math.pow(2.0, m.toDouble()).toInt())
}

