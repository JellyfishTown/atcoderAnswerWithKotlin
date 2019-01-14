package participated.ext003

//https://aising2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val xList = mutableListOf<Long>()
    (1..n).forEach {
        xList.add(readLine()!!.toLong())
    }
    val sum = aList.sum()

    println()
}
