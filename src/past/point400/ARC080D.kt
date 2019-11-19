package past.point400

import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val n = readLine()!!.toInt()
    val aQueue = ArrayDeque<Int>(readLine()!!.split(' ').map(String::toInt))

    val map = Array(h) { IntArray(w) { 0 } }
    var curNum = 1
    var count = aQueue.pollFirst()!!
    var reverse = false
    for (r in 0 until h) {
        for (tc in 0 until w) {
            if (reverse) {
                map[r][w - tc - 1] = curNum
            } else {
                map[r][tc] = curNum
            }
            count--
            if (count == 0) {
                curNum++
                count = aQueue.pollFirst()?:0
            }
        }
        reverse = !reverse
    }
    map.forEach { println(it.joinToString(" ")) }
}
