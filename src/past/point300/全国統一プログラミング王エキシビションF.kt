//https://atcoder.jp/contests/nikkei2019-ex/tasks/nikkei2019ex_e
fun main(args: Array<String>) {
    var ans = 1789997546303L
    for (i in 0 until (1000 - readLine()!!.toLong()))
        ans = if (ans % 2 == 1L) ans * 3 + 1 else ans / 2
    println(ans)
}
