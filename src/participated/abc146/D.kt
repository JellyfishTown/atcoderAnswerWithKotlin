package participated.abc146

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val branches = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }//行先、枝番号
    val colors = Array(n + 1) { 0 }
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        branches[a].add(Pair(b, it))
        branches[b].add(Pair(a, it))
    }

    val queue = ArrayDeque<Pair<Int, Int>>()//to,from color
    queue.add(Pair(1, 0))
    while (queue.isNotEmpty()) {
        val (cur, fromColor) = queue.pop()
        var nextColor = if (fromColor == 1) 2 else 1
        val bs = branches[cur]
        for (b in bs) {
            val (to, bnum) = b
            if (colors[bnum] != 0) continue
            colors[bnum] = nextColor
            queue.add(Pair(to,nextColor))
            nextColor++
            if (nextColor == fromColor) nextColor++
        }
    }


    println(colors.max())
    for (i in 1 until n) {
        println(colors[i])
    }
}