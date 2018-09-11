package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val map = mutableMapOf<Long, Long>()
    aList.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1L
        } else {
            map[it] = 1L
        }
    }
    val countMap = map.filterValues { it >= 2L }
    if (countMap.size < 2) {
        println(0)
        return
    }
    val (first, second) = countMap.keys.toList().sortedDescending().subList(0, 2)
    if (countMap[first]!! >= 4) {
        println(first * first)
    } else {
        println(first * second)
    }
}
