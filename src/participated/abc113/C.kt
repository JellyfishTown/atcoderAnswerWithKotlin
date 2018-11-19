package participated.abc113

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val data = mutableListOf<Triple<Long, Long, Long>>()
    (1..m).forEach {
        val (p, y) = readLine()!!.split(' ').map(String::toLong)
        data.add(Triple(it, p, y))
    }
    data.sortBy { it.third }
    data.sortBy { it.second }
    val result = mutableMapOf<Long, String>()
    var countP = 1
    var currentP = data[0].second
    result[data[0].first] = data[0].second.toString().padStart(6, '0') + countP.toString().padStart(6, '0')
    for (i in 1 until m.toInt()) {
        if (currentP != data[i].second) {
            currentP = data[i].second
            countP = 1
        } else {
            countP++
        }
        result[data[i].first] = data[i].second.toString().padStart(6, '0') + countP.toString().padStart(6, '0')
    }
    (1..m).forEach { println(result[it]) }
}
