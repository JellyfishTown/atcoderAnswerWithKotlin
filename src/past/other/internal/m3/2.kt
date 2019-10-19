package past.other.internal.m3

import java.util.*

fun main(args: Array<String>) {

    //input受取
    val (r, c) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(r + 2) { Array(c + 2) { 'x' } }

    //最寄りの*までの距離を格納する配列。Intの最大値で初期化
    val distMap = Array(r + 2) { Array(c + 2) { Int.MAX_VALUE } }
    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    //bfsやるためのQueue
    val queue = ArrayDeque<Pair<Int, Int>>()

    //input受け取り
    (1..r).forEach { tr ->
        val line = readLine()!!.toCharArray()
        (1..c).forEach { tc ->
            map[tr][tc] = line[tc - 1]
            if (map[tr][tc] == '*') {
                queue.add(Pair(tr, tc))
                distMap[tr][tc] = 0
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (tr, tc) = queue.pop()
        for (d in 0..3) {
            val nr = tr + dy[d]
            val nc = tc + dx[d]
            if (map[nr][nc] == '.') {
                if (distMap[nr][nc] > distMap[tr][tc] + 1) {
                    distMap[nr][nc] = distMap[tr][tc] + 1
                    queue.add(Pair(nr, nc))
                }
            }
        }
    }
    var ans = 0
    for (tr in 1..r) {
        for (tc in 1..c) {
            ans = Math.max(ans,distMap[tr][tc])
        }
    }
    println(ans)
}