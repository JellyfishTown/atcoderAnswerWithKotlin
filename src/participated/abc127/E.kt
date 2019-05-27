package participated.abc127

fun main(args: Array<String>) {
    val (n, m, k) = readLine()!!.split(' ').map(String::toLong)
    val mod = 1000000000L + 7L
    val a = nCk((n * m).toInt(),k.toInt(),mod.toInt()) - nCk((n * m - 1).toInt(),k.toInt(),mod.toInt())
    println()
}

fun nCk(n: Int, k: Int, M: Int): Int {
    var ret: Long = 1
    val min = Math.min(k, n - k)
    for (i in 1..min) {
        ret = ret * pow(i.toLong(), (M - 2).toLong(), M) % M
    }
    for (i in n - min + 1..n) {
        ret = ret * i % M
    }
    return ret.toInt()
}
fun pow(a: Long, b: Long, M: Int): Long {
    var b = b
    var ret: Long = 1
    var tmp = a
    while (b > 0) {
        if (b and 1 == 1L) ret = ret * tmp % M
        tmp = tmp * tmp % M
        b = b shr 1
    }
    return ret
}