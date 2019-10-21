package participated.abc142

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    println(if (n % 2 == 0) 0.5 else (n / 2 + 1).toDouble() / n.toDouble())
}