package participated.abc105

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val cumSum = mutableListOf(0L)
    aList.forEach { cumSum.add(cumSum.last() + it) }
    val modMap = mutableMapOf<Long, Long>()
    cumSum.forEach { modMap[it % m] = (modMap[it % m] ?:0L) + 1L }
    var ans = 0L
    for ((key, value) in modMap) {
        ans += (value * (value - 1)) / 2
    }
    println(ans)
}
