package participated.ext005

//https://yahoo-procon2019-qual.contest.atcoder.jp/assignments
fun main(args: Array<String>) {
    val ans = IntArray(4) { 0 }
    val (a1, b1) = readLine()!!.split(' ').map(String::toInt)
    ans[a1 - 1] += 1
    ans[b1 - 1] += 1
    val (a2, b2) = readLine()!!.split(' ').map(String::toInt)
    ans[a2 - 1] += 1
    ans[b2 - 1] += 1
    val (a3, b3) = readLine()!!.split(' ').map(String::toInt)
    ans[a3 - 1] += 1
    ans[b3 - 1] += 1

    if (ans.contains(0) || ans.contains(3)) {
        println("NO")
    } else {
        println("YES")
    }
}
