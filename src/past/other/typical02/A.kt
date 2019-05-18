package past.other.typical02

import java.util.ArrayDeque
fun main(args: Array<String>) {
    val (r, c) = readLine()!!.split(' ').map(String::toInt)
    val (sx, sy) = readLine()!!.split(' ').map { it.toInt() - 1 }
    val (gx, gy) = readLine()!!.split(' ').map { it.toInt() - 1 }
    val map = Array(r) { readLine()!!.toCharArray() }
    val costMap = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val dist = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    costMap[sx][sy] = 0
    queue.push(Pair(sx, sy))
    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.pop()
        for ((dx, dy) in dist) {
            map.getOrNull(cx + dx)?.getOrNull(cy + dy)?.let {
                if (costMap[cx][cy] + 1 < costMap[cx + dx][cy + dy] && map[cx + dx][cy + dy] == '.') {
                    costMap[cx + dx][cy + dy] = costMap[cx][cy] + 1
                    queue.push(Pair(cx + dx, cy + dy))
                }
            }
        }
    }
    println(costMap[gx][gy])
}
