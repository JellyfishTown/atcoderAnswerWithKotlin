package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = mutableMapOf<Char, Long>()
    val march = mutableListOf('M', 'A', 'R', 'C', 'H')
    for (i in march) {
        map[i] = 0L
    }
    for (i in 1..n) {
        val s = readLine()!!
        val first = s.first()
        if (first in march) map[first] = map[first]!! + 1
    }

    var count = 0L
    for (i in 0..2) {
        for (j in i + 1..3) {
            for (k in j + 1..4) {
                count += map[march[i]]!! * map[march[j]]!! * map[march[k]]!!
            }
        }
    }

    println(count)
}
