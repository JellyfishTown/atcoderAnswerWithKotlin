package past.point400

import java.util.*

fun main(args: Array<String>) {
    val diff = 100000000000L
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val branch = Array(n + 1) { mutableListOf<Pair<Int, Long>>() }
    val visited = Array(n + 1) { false }
    val dist = Array(n + 1) { Long.MIN_VALUE }
    (1..m).forEach {
        val (l, r, d) = readLine()!!.split(' ').map(String::toLong)
        branch[l.toInt()].add(Pair(r.toInt(), d))
        branch[r.toInt()].add(Pair(l.toInt(), -d))
    }

    var baseDist = 0L
    for (startPos in 1..n) {
        val queue = ArrayDeque<Int>()
        if (visited[startPos]) continue
        queue.add(startPos)
        visited[startPos] = true
        dist[startPos] = baseDist
        baseDist += diff
        while (queue.isNotEmpty()) {
            val cur = queue.pollFirst()!!
            val bs = branch[cur]
            for (b in bs) {
                val (to, cost) = b
                if(visited[to]){
                    if(dist[to]!=dist[cur]+cost){
                        println("No")
                        return
                    }
                }else{
                    queue.add(to)
                    visited[to]=true
                    dist[to] = dist[cur]+cost
                }
            }
        }
    }

    println("Yes")
}
