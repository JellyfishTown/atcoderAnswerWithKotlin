fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map(String::toLong)
    val rail = mutableMapOf<Long, MutableList<Long>>()
    for (i in 0 until M) {
        val (a, b, l) = readLine()!!.split(" ").map(String::toLong)
        rail.getOrPut(a) { mutableListOf() }.add(l)
        rail.getOrPut(b) { mutableListOf() }.add(l)
    }
    rail.values.forEach { it.sort() }
    var count = 0L
    for (i in 1..N) {
        val list = rail[i] ?: continue
        val countMap = mutableMapOf<Long, Long>()
        list.forEach { countMap[it] = (countMap[it] ?: 0) + 1 }
        for (len in 1000L..1540L) {
            if (countMap[len] != null) {
                if (len == 1270L) {
                    count += (countMap[1270]!! * (countMap[1270]!! - 1L))
                } else {
                    count += (countMap[len]!! * (countMap[2540 - len] ?: 0L))
                }
            }
        }
    }
    println(count / 2)
}
