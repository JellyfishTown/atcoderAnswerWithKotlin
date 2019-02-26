//https://atcoder.jp/contests/nikkei2019-ex/tasks/nikkei2019ex_f
fun main(args: Array<String>) {
    var ans = 1L
    val n = readLine()!!.toLong()
    if (n <= 1) {
        println(0)
        return
    }
    for (i in 1..n) {
//        if (ans > 4 && ((ans - 1) % 3) == 0L && ((ans - 1) / 3) % 2 == 1L) ans = (ans - 1) / 3
        if (ans > 4 && ((ans - 1) % 3) == 0L) ans = (ans - 1) / 3
        else ans *= 2
    }
    println(ans)
}
