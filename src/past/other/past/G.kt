package past.other.past

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = Array(n + 1) { LongArray(n + 1) { 0 } }
    (n - 1 downTo 1).forEach {
        val s = readLine()!!.split(' ')
        for (i in 1..it) {
            map[n - it][n - it + i] = s[i - 1].toLong()
            map[n - it + i][n - it] = s[i - 1].toLong()
        }
    }
    fun calc(g1: List<Int>, g2: List<Int>, g3: List<Int>): Long {
        var sum = 0L
        if (g1.size >= 2)
            for (i in 0..g1.size - 2)
                for (j in i + 1 until g1.size)
                    sum += map[g1[i]][g1[j]]
        if (g2.size >= 2)
            for (i in 0..g2.size - 2)
                for (j in i + 1 until g2.size)
                    sum += map[g2[i]][g2[j]]
        if (g3.size >= 2)
            for (i in 0..g3.size - 2)
                for (j in i + 1 until g3.size)
                    sum += map[g3[i]][g3[j]]
        return sum
    }

    fun plusEx(g: IntArray): Boolean {
        for (i in 1..n) {
            if (g[i] == 3) {
                g[i] = 1
            } else {
                g[i] = g[i] + 1
                return true
            }
        }
        return false
    }

    val g = IntArray(n + 1) { 0 }
    (1..n).forEach { g[it] = 1 }
    var ans = Long.MIN_VALUE
    val member = (1..n)
    do {
        ans = Math.max(ans,
                calc(
                        member.filter { g[it] == 1 },
                        member.filter { g[it] == 2 },
                        member.filter { g[it] == 3 }
                ))
    } while (plusEx(g))
    println(ans)
}
