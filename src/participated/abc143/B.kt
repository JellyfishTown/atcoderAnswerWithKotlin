package participated.abc143

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val dList = readLine()!!.split(' ').map(String::toLong)
    var sum = 0L
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            sum += dList[i] * dList[j]
        }
    }
    println(sum)
}