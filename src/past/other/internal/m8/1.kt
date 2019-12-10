package past.other.internal.m8

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    if (n % 100 != 0) {
        println(-1)
    } else {
        println(n / 500 + (n % 500) / 100)
    }
}
