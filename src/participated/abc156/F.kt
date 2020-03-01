package participated.abc156

fun main(args: Array<String>) {
    val (k, q) = readLine()!!.split(' ').map(String::toLong)
    val dList = readLine()!!.split(' ').map(String::toLong).toLongArray()
    val dSize = dList.size
    for (i in 1..q) {
        val (n, x, mod) = readLine()!!.split(' ').map(String::toLong)
        val max = (n - 1).toInt()
        val ddList = dList.map { it % mod }.toLongArray()
        val ddSum = ddList.sum()
        val first = x % mod
        val times = max / dSize
        val start = (times * dSize + 1)
        val left = (start..max).map { ddList[(it - 1) % dSize] }.sum()
        val timesSum = first + ddSum * times + left
        val revTimes = timesSum / mod
        val leftZero = (start..max).count { ddList[(it - 1) % dSize] == 0L }
        val countZero = ddList.count { it == 0L } * times + leftZero
        val ans = max - revTimes - countZero
        println(ans)
    }
}
