package participated.abc160

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    println((n / 500 * 1000) + (n - (n / 500 * 500)) / 5 * 5)
}
