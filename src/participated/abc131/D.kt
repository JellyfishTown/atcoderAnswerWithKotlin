package participated.abc131

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val abList = mutableListOf<Pair<Long, Long>>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        abList.add(Pair(a, b))
    }
    abList.sortBy { it.second }

    var sum = 0L
    for (i in 0 until n) {
        sum += abList[i].first
        if (sum > abList[i].second) {
            println("No")
            return
        }
    }
    println("Yes")
}
