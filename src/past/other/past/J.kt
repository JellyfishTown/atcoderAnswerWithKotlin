package past.other.past

import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val costMap = Array(h) { readLine()!!.split(" ").map(String::toLong).toLongArray() }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val startCost = Array(h) { LongArray(w) { Long.MAX_VALUE / 10 } }.apply { this[h - 1][0] = 0 }
    val startFrom = Array(h) { Array<Pair<Int, Int>?>(w) { null } }
    val middleCost = Array(h) { LongArray(w) { Long.MAX_VALUE / 10 } }.apply { this[h - 1][w - 1] = 0 }
    val middleFrom = Array(h) { Array<Pair<Int, Int>?>(w) { null } }
    val goalCost = Array(h) { LongArray(w) { Long.MAX_VALUE / 10 } }.apply { this[0][w - 1] = 0 }
    val goalFrom = Array(h) { Array<Pair<Int, Int>?>(w) { null } }

    fun calcCost(map: Array<LongArray>, mapFrom: Array<Array<Pair<Int, Int>?>>, start: Pair<Int, Int>) {
        val dxl = arrayOf(1, 0, -1, 0)
        val dyl = arrayOf(0, 1, 0, -1)
        queue.add(start)
        while (queue.isNotEmpty()) {
            val (th, tw) = queue.pop()
            for (i in 0..3) {
                val nextw = tw + dxl[i]
                val nexth = th + dyl[i]
                if (nexth in 0 until h && nextw in 0 until w) {
                    if (map[nexth][nextw] > map[th][tw] + costMap[nexth][nextw]) {
                        map[nexth][nextw] = map[th][tw] + costMap[nexth][nextw]
                        queue.add(Pair(nexth, nextw))
                        mapFrom[nexth][nextw] = Pair(th, tw)
                    }
                }
            }
        }
    }

    calcCost(startCost, startFrom, Pair(h - 1, 0))
    calcCost(middleCost, middleFrom, Pair(h - 1, w - 1))
    calcCost(goalCost, goalFrom, Pair(0, w - 1))

    var minCost = Long.MAX_VALUE
    for (i in 0 until h) {
        for (j in 0 until w) {
            val log = mutableSetOf<Pair<Int, Int>>()
            var tempCost = costMap[i][j]
            fun sumCost(fromMap: Array<Array<Pair<Int, Int>?>>, from: Pair<Int, Int>?) {
                var fromIn = from
                while (fromIn != null) {
                    val (th, tw) = fromIn
                    if (log.contains(fromIn).not()) {
                        tempCost += costMap[th][tw]
                        log.add(fromIn)
                    }
                    fromIn = fromMap[th][tw]
                }
            }
            sumCost(startFrom, startFrom[i][j])
            sumCost(middleFrom, middleFrom[i][j])
            sumCost(goalFrom, goalFrom[i][j])
            minCost = Math.min(minCost, tempCost)
        }
    }
    println(minCost)
}
