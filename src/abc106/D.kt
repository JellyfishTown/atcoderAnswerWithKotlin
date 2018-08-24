package abc106

fun main(args: Array<String>) {
    val (n, m, q) = readLine()!!.split(' ').map(String::toInt)
    val map = mutableMapOf<Int, MutableMap<Int, Int>>()
    for (i in 1..m) {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        for (j in 1..l) {
            if (map.containsKey(j).not()) {
                map[j] = mutableMapOf()
            }
            for (k in r..n) {
                map[j]!![k] = (map[j]!![k] ?: 0) + 1
            }
        }

    }
    for (i in 1..q) {
        val (pi, qi) = readLine()!!.split(' ').map(String::toInt)
        println(map[pi]!![qi])
    }
}
