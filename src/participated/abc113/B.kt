package participated.abc113

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val (t, a) = readLine()!!.split(' ').map(String::toLong)
    val hList = readLine()!!.split(' ').map(String::toLong)
    val tList = hList.map { t - it * 0.006 }
    val dList = mutableMapOf<Int, Double>()
    tList.forEachIndexed { index, d -> dList[index] = Math.abs(d - a) }
    println(dList.minBy { it.value }!!.key + 1)
}


