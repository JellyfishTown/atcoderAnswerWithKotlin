package past.other.internal.m1

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    if (n % 100 != 0) {
        println(-1)
        return
    }
    println(n / 500 + (n % 500) / 100)
}
