package past.other.internal.m5

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    var tc = 0L
    for (i in 1 until (n - 1)) {
        val prev = aList[i - 1]
        val cur = aList[i]
        val next = aList[i + 1]
        if (prev > cur && next > cur) {
            val min = Math.min(prev, next)
            tc += min - cur
            aList[i] = min
        } else if (prev < cur && next < cur) {
            val max = Math.max(prev, next)
            tc += cur - max
            aList[i] = max
        }
    }
    for (i in 1 until n) {
        tc += Math.abs(aList[i] - aList[i - 1])
    }
    println(tc)
}