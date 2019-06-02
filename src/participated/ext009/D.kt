package participated.ext009

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val ab = Array(n - 1) { readLine()!!.split(" ").map(String::toInt) }
    val c = readLine()!!.split(" ").map { it.toInt() }.sortedDescending().toIntArray()
    println(c.sum() - c.max()!!)

    val link = Array(n + 1) { ArrayList<Int>() }
    ab.forEach {
        link[it[0]].add(it[1])
        link[it[1]].add(it[0])
    }
    val visit = BooleanArray(n + 1) { false }
    val result = IntArray(n + 1) { 0 }
    val queue = ArrayDeque<Int>()
    visit[1] = true
    queue.add(1)
    var cursor = 1
    while (!queue.isEmpty()) {
        val node = queue.pop()
        link[node].forEach {
            if (!visit[it]) {
                visit[it] = true
                queue.add(it)
            }
        }
        result[node] = c[cursor - 1]
        cursor += 1
    }
    println(result.takeLast(n).joinToString(" "))
}