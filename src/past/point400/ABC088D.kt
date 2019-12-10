package past.point400
//探索 BFS DFS
import java.util.*

fun main(args: Array<String>) {
    val (r, c) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(r + 2) { CharArray(c + 2) { '#' } }
    (1..r).forEach {
        map[it] = readLine()!!
                .toMutableList()
                .apply { this.add(0, '#') }
                .apply { this.add(this.size, '#') }
                .toCharArray()
    }
    val branch = Array((r + 1) * (c + 1)) { mutableListOf<Int>() }
    for (i in 1..r) {
        for (j in 1..c) {
            val cur = j + (c * (i - 1))
            if (map[i][j] == '.' && map[i][j + 1] == '.') {
                branch[cur].add(cur + 1)
                branch[cur + 1].add(cur)
            }
            if (map[i][j] == '.' && map[i + 1][j] == '.') {
                branch[cur].add(cur + c)
                branch[cur + c].add(cur)
            }
        }
    }

    val minCost = Array((r + 1) * (c + 1)) { Int.MAX_VALUE }
    minCost[1] = 1

    val queue = ArrayDeque<Int>().apply { addFirst(1) }
    while (queue.isNotEmpty()) {
        val cur = queue.pollLast()!!
        for (to in branch[cur]) {
            if (minCost[to] > minCost[cur] + 1) {
                minCost[to] = minCost[cur] + 1
                queue.addFirst(to)
            }
        }
    }
    if (minCost[r * c] == Int.MAX_VALUE) {
        println(-1)
    } else {
        val pCount = map.map { it.count { it == '.' } }.sum()
        println(pCount - minCost[r * c])
    }
}
