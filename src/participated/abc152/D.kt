package participated.abc152

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 1..n) {
        val s = i.toString()
        val l = s.first().toString()
        val r = s.last().toString()
        map[l + r] = (map.get(l + r) ?: 0) + 1
    }
    var ans = 0L
    for (key in map.keys) {
        val num1 = map[key]!!
        val num2 = map.get(key.reversed()) ?: 0
        ans += num1 * num2
    }
    println(ans)
}