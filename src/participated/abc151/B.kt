package participated.abc151

fun main(args: Array<String>) {
    val (n, k, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val aSum = aList.sum()
    val target = n * m

    if (aSum + k < target) {
        println(-1)
    } else {
        println(Math.max(target - aSum, 0))
    }
}