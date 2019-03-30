package participated.ext004

//https://nikkei2019-qual.contest.atcoder.jp/#
fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
    println(Math.min(a, b).toString() + " " + Math.max(a + b - n, 0))
}
