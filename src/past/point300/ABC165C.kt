package past.point300

import kotlin.math.max

fun main(args: Array<String>) {
    val (n, m, q) = readLine()!!.split(' ').map(String::toInt)
    val nArray = IntArray(n + 1) { 1 }
    val aArray = IntArray(q + 1) { 0 }
    val bArray = IntArray(q + 1) { 0 }
    val cArray = IntArray(q + 1) { 0 }
    val dArray = IntArray(q + 1) { 0 }

    fun increase(i: Int = n): Boolean {
        if (nArray[i] == m) {
            if (i == 1) {
                return false
            }
            return increase(i - 1)
        } else {
            nArray[i]++
            for (j in i + 1..n) {
                nArray[j] = nArray[i]
            }
            return true
        }
    }
    for (i in 1..q) {
        val (a, b, c, d) = readLine()!!.split(' ').map(String::toInt)
        aArray[i] = a
        bArray[i] = b
        cArray[i] = c
        dArray[i] = d
    }
    fun calcScore() = (1..q).map { i ->
        if (nArray[bArray[i]] - nArray[aArray[i]] == cArray[i]) dArray[i].toLong() else 0L
    }.sum()
    var score = calcScore()
    while (increase()) {
        score = max(score,calcScore())
    }
    println(score)
}
