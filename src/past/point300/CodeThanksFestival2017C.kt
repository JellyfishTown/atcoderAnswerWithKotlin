import java.util.*


fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toLong)

    val input = PriorityQueue<Pair<Long, Long>>(1, MyComparator())
    for (i in 1..n) {
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        input.add(Pair(a, b))
    }
    var sum = 0L
    for (i in 1..k) {
        val poll = input.poll()
        sum += poll.first
        input.add(Pair(poll.first + poll.second, poll.second))
    }
    println(sum)
}

class MyComparator : Comparator<Pair<Long, Long>> {
    override fun compare(p1: Pair<Long, Long>, p2: Pair<Long, Long>): Int {
        return when {
            p1.first > p2.first -> 1
            p1.first < p2.first -> -1
            else -> 0
        }
    }
}