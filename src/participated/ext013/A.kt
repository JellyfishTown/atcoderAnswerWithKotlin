package participated.ext013

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val stList = mutableListOf<Pair<String, Long>>()
    (1..n).forEach {
        val (s, t) = readLine()!!.split(' ')
        stList.add(Pair(s, t.toLong()))
    }
    val x = readLine()!!
    val total = stList.map { it.second }.sum()
    var heard = 0L
    var i = 0
    while (true) {
        heard += stList[i].second
        if (x == stList[i].first) break
        i++
    }
    println(total-heard)
}