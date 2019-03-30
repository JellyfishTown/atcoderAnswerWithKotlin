package participated.ext005

//https://yahoo-procon2019-qual.contest.atcoder.jp/assignments
fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    if (Math.ceil(n.toDouble() / 2).toLong() >= k) {
        println("YES")
    } else {
        println("NO")
    }
}
