package participated.ext002

//https://aising2019.contest.atcoder.jp
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = readLine()!!.toInt()
    val w = readLine()!!.toInt()
    println((n - w + 1) * (n - h + 1))
}
