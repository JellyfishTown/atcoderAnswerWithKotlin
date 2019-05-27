package participated.abc128

import java.util.*

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val vList = readLine()!!.split(' ').map(String::toLong)
    val queue = ArrayDeque<Long>()
    vList.forEach { queue.add(it) }

    var ans = 0L
    for (tk in 1..k) {
        for (left in 0..tk) {
            val tq = queue.clone()
            val have = mutableListOf<Long>()
            val right = tk - left
            for (i in 1..left) {
                if (tq.isNotEmpty()) have.add(tq.pollFirst())
            }
            for (i in 1..right) {
                if (tq.isNotEmpty()) have.add(tq.pollLast())
            }

            if (have.isEmpty()) break
            have.sort()
            var re = k - tk
            while (re-- > 0 && have[0] <= 0) {
                have.removeAt(0)
                if (have.isEmpty()) break
            }
            ans = Math.max(ans, have.sum())
        }
    }
    println(ans)
}
