package past.point300

//https://atcoder.jp/contests/chokudai_S001/tasks/chokudai_S001_g
fun main(args: Array<String>) {
    val mod = 1000000007L
    val n = readLine()!!.toInt()
    val xList = readLine()!!.split(' ').map(String::toInt)
    var ans = 0L
    for (x in xList) {
        ans *= Math.pow(10.0, x.toString().length.toDouble()).toLong()
        ans %= mod
        ans += x
        ans %= mod
    }
    println(ans)
}

