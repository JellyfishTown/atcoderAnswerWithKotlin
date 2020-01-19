package participated.abc151

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(h + 2) { CharArray(w + 2) { '#' } }
    (1..h).forEach {
        val s = readLine()!!
        for (i in 0 until w) {
            map[it][i + 1] = s[i]
        }
    }

    val minCost = Array(h * w + 1) { LongArray(h * w + 1) { Long.MAX_VALUE / 10 } }
    for (i in 0..(h * w)) {
        minCost[i][i] = 0
    }
    for (i in 1..h) {
        for (j in 1..w) {
            val cur = map[i][j]
            val right = map[i][j + 1]
            val down = map[i + 1][j]
            val curNum = (i - 1) * w + j
            if (cur == '.' && right == '.') {
                val rightNum = (i - 1) * w + j + 1
                minCost[curNum][rightNum] = 1
                minCost[rightNum][curNum] = 1
            }
            if (cur == '.' && down == '.') {
                val downNum = (i - 1) * w + j + w
                minCost[curNum][downNum] = 1
                minCost[downNum][curNum] = 1
            }
        }
    }
    for (j in 1..(h * w))
        for (i in 1..(h * w))
            for (k in 1..(h * w))
                minCost[i][k] = Math.min(minCost[i][k], minCost[i][j] + minCost[j][k])
    val max = minCost.map { it.filter { it < 10000 }.max() ?: 0 }.max()!!
    println(max)
}