fun main(args: Array<String>) {
    val (nl, c) = readLine()!!.split(" ").map(String::toLong)
    val n = nl.toInt()
    val xMap = mutableMapOf(Pair(0, 0L))
    val xReverseMap = mutableMapOf(Pair(0, 0L))
    val vMap = mutableMapOf(Pair(0, 0L))
    val vSumMap = mutableMapOf(Pair(0, 0L))
    val vSumReverseMap = mutableMapOf(Pair(0, 0L))
    val cMap = mutableMapOf(Pair(0, 0L))
    val cReverseMap = mutableMapOf(Pair(0, 0L))
    for (i in 1..n) {
        val (x, v) = readLine()!!.split(" ").map(String::toLong)
        xMap[i] = x
        vMap[i] = v
        vSumMap[i] = vSumMap[i - 1]!! + v
        cMap[i] = vSumMap[i]!! - xMap[i]!!

    }
    (1..n).forEach { i ->
        xReverseMap[i] = c - xMap[n - i + 1]!!
    }
    (1..n).forEach { i ->
        vSumReverseMap[i] = vSumReverseMap[i - 1]!! + vMap[n - i + 1]!!
        cReverseMap[i] = vSumReverseMap[i]!! - xReverseMap[i]!!
    }

    var max = 0L
    for (i in 0..n) {
        val t = cReverseMap.filter { it.key<= (n - i) }.maxBy { cMap[i]!! + it!!.value - Math.min(xMap[i]!!, xReverseMap[it.key]!! )}
        val temp = cMap[i]!! + t!!.value - Math.min(xMap[i]!!, xReverseMap[t.key]!!)
        max = Math.max(temp, max)
    }
    println(max)
}

