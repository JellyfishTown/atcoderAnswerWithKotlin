package past.other.educationaldp

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hList = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(n) { 0L }
    dp[1] = Math.abs(hList[1] - hList[0]).toLong()
    for (i in 2 until n) {
        dp[i] = Math.min(
                dp[i - 1] + Math.abs(hList[i] - hList[i - 1]),
                dp[i - 2] + Math.abs(hList[i] - hList[i - 2])
        )
    }
    println(dp.last())
}
