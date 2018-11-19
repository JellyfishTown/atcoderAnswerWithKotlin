package participated.abc113

fun main(args: Array<String>) {
    val num = readLine()!!.toLong()
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    for (a in m / n downTo 1) {
        if (m % a == 0L && a * n <= m) {
            println(a)
            return
        }
    }
}


