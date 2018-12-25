package participated.ext001

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val aList = mutableListOf<Long>()
    (1..n).forEach {aList.add(readLine()!!.toLong()) }
    println(if (aList.all { it % 2L == 0L }) "second" else "first")
}

