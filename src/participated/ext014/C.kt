package participated.ext014

fun main(args: Array<String>) {
    val sMax = 1000000000L
    val (n, k, s) = readLine()!!.split(' ').map(String::toLong)
    if (s == sMax) {
        val ans = LongArray(n.toInt()) { 1L }
        (0 until k).forEach { ans[it.toInt()] = s }
        println(ans.joinToString(" "))
    } else {
        val ans = LongArray(n.toInt()) { s + 1 }
        (0 until k).forEach { ans[it.toInt()] = s }
        println(ans.joinToString(" "))
    }
}