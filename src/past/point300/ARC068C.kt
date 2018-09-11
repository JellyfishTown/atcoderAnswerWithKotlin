package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val syou = n / 11
    val amari = n % 11
    when {
        amari == 0L -> println(syou * 2)
        amari < 7 -> println(syou * 2 + 1)
        else -> println(syou * 2 + 2)
    }
}
