package participated.abc127

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    val bcList = mutableListOf<Pair<Long, Long>>()
    for (i in 1..m) {
        val (b, c) = readLine()!!.split(' ').map(String::toLong)
        bcList.add(Pair(b, c))
    }
    bcList.sortByDescending { entry -> entry.second }

    val list = mutableListOf<Long>()
    for ((b, c) in bcList) {
        for (i in 1..b) list.add(c)
        if (list.size >= n) {
            break
        }
    }
    aList.addAll(list)
    aList.sortDescending()
    println(aList.take(n.toInt()).sum())
}
