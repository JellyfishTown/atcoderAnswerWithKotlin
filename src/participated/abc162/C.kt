package participated.abc162

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = Array(n + 1) { LongArray(n + 1) { 0 } }
    fun gcd(a: Long, b: Long): Long {
        if (map[a.toInt()][b.toInt()] != 0L) return map[a.toInt()][b.toInt()]
        return if (b > 0) gcd(b, a % b) else a
    }

    fun gcd(a: Long, b: Long, c: Long): Long {
        val g = gcd(a, b)
        return gcd(g, c)
    }



    for (i in 1..n) {
        for (j in 1..n) {
            map[i][j] = gcd(i.toLong(), j.toLong())
        }
    }
    var ans = 0L
    for (i in 1L..n) {
        for (j in 1L..n) {
            for (k in 1L..n) {
                ans += gcd(i, j, k)
            }
        }
    }
    println(ans)
}
