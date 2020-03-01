package participated.abc155

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = (1..n).map { readLine()!! }
    val g = sList.groupBy { it }
    val max = g.map { it.value.size }.max()!!
    val ansSet = mutableSetOf<String>()
    g.forEach { if (it.value.size == max) ansSet.add(it.key) }
    ansSet.sorted().forEach { println(it) }
}
