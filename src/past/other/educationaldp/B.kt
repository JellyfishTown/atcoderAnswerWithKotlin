package past.other.educationaldp

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val hList = readLine()!!.split(' ').map(String::toInt)
    val dp = Array(n) { Long.MAX_VALUE }
    dp[0] = 0L
    for (ni in 1 until n) {
        for (ki in 1..Math.min(k, ni)) {
            dp[ni] = Math.min(
                    dp[ni],
                    dp[ni - ki] + Math.abs(hList[ni] - hList[ni - ki])
            )
        }
    }
    println(dp.last())
}
