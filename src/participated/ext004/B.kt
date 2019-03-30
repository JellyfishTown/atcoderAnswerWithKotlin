package participated.ext004

//https://nikkei2019-qual.contest.atcoder.jp/#
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!
    var count = 0L
    for (i in 0 until n) {
        when {
            (a[i] == b[i] && a[i] == c[i]) -> {
                //do nothing
            }
            (a[i] != b[i] && a[i] != c[i] && b[i] != c[i]) -> {
                count += 2
            }
            else -> {
                count++
            }
        }

    }
    println(count)
}
