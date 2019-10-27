package participated.abc143

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    var count = 1L
    for (i in 0 until n - 1) {
        if (s[i] != s[i + 1]) count++
    }
    println(count)
}