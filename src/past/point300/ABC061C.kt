package past.point300

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toLong)
    val ab = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until n.toInt()) {
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        ab.add(Pair(a, b))
    }
    ab.sortBy { it.first }

    var bSum = 0L
    for (i in 0 until n.toInt()) {
        bSum += ab[i].second
        if (bSum >= k) {
            println(ab[i].first)
            return
        }
    }
}


