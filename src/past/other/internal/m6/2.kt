package past.other.internal.m6

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = (1..n).map { readLine()!!.toLong() }
    val used = Array(n + 1) { false }
    var ans = 0L
    for (p in pList) {
        var temp = 2 * p
        used[p.toInt()] = true
        while (temp <= n) {
            if (used[temp.toInt()].not()) ans++
            temp *= 2
        }
    }
    println(ans)
}
