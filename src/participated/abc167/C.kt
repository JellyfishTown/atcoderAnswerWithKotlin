package participated.abc167

fun main(args: Array<String>) {
    val (n, m, x) = readLine()!!.split(' ').map(String::toLong)
    val input = mutableListOf<List<Long>>()
    (1..n).forEach {
        input.add(readLine()!!.split(' ').map(String::toLong))
    }
    val pattern = IntArray(n.toInt()) { 0 }

    fun addP(i: Int = 0): Boolean {
        if (i == n.toInt() - 1 && pattern[i] == 1) {
            return false
        }
        if (pattern[i] == 0) {
            pattern[i] = 1
            return true
        } else {
            for (j in 0..i) pattern[j] = 0
            return addP(i + 1)
        }
    }

    var minCost = Long.MAX_VALUE
    fun calcCost(): Long {
        var cost = 0L
        val aL = LongArray(m.toInt()) { 0L }
        for (i in 0 until n.toInt()) {
            if (pattern[i] == 1) {
                cost += input[i][0]
                for (mi in 0 until m.toInt()) {
                    aL[mi] += input[i][mi + 1]
                }
            }
        }
        if(aL.all { it>=x })return cost
        else return Long.MAX_VALUE
    }

    while (addP()) {
//        println(pattern.joinToString(","))
        minCost = Math.min(minCost, calcCost())
    }
    if(minCost==Long.MAX_VALUE) println(-1)
    else println(minCost)
}
