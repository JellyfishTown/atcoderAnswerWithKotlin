package participated.abc139

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hList = readLine()!!.split(' ').map(String::toLong).reversed()
    var cur = 0
    var ans = 0

    (1 until n).forEach {
        if (hList[it - 1] <= hList[it]) {
            cur++
        } else {
            cur = 0
        }
        ans = Math.max(ans, cur)
    }
    println(ans)
}
