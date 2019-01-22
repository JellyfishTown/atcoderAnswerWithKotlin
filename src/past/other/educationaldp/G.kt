package past.other.educationaldp

var dp = Array(100001) { -1L }
val g = mutableMapOf<Int, MutableList<Int>>()

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    for (i in 1..m) {
        val (x, y) = readLine()!!.split(' ').map(String::toInt)
        if (g.containsKey(x)) g[x]!!.add(y) else g[x] = mutableListOf(y)
    }
    var temp = 0L
    g.keys.forEach { temp = Math.max(temp, rec(it)) }
    println(dp.max())

}

fun rec(cur: Int): Long {
    if (dp[cur] != -1L) return dp[cur]
    var temp = 0L
    g[cur]?.forEach {
        temp = Math.max(temp, rec(it) + 1)
    }
    dp[cur] = temp
    return temp
}

