package past.point400
fun main(args: Array<String>) {
    val (n, a, b, c, d) = readLine()!!.split(" ").map(String::toLong)
    for (minusTimes in 0 until n) {
        val plusTimes = (n - 1 - minusTimes)
        val max = a - c * minusTimes + d * plusTimes //minusTimes回引き算を行う場合の最大値
        val min = a - d * minusTimes + c * plusTimes
        if (b in min..max) {
            println("YES")
            return
        }
    }
    println("NO")
}
