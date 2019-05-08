import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val map = Array(h) { readLine()!!.toCharArray().map { c -> if (c == '.') -1 else 0 }.toIntArray() }
    val queue = ArrayDeque<Int>()
    for (th in 0 until h) for (tw in 0 until w) if (map[th][tw] == 0) queue.offer(10000 * th + tw)

    val dir = mutableListOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))//上下左右
    var max = 0
    while (queue.size > 0) {
        val q = queue.poll()!!
        for (d in dir) {
            val qh = q / 10000
            val qw = q % 10000
            val th = qh + d.first
            val tw = qw + d.second
            if (th in 0 until h && tw in 0 until w && map[th][tw] == -1) {
                queue.offer(10000 * th + tw)
                val next = map[qh][qw] + 1
                map[th][tw] = next
                max = Math.max(max, next)
            }
        }
    }
    println(max)
}
