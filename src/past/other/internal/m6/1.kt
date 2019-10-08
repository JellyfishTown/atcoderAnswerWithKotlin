package past.other.internal.m6

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = Array(1001) { mutableSetOf<Int>() }
    (1 until n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        map[a].add(b)
        map[b].add(a)
    }
    val max = map.map { it.size }.max()!!
    println(max)
}
