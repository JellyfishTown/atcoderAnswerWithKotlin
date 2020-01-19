package participated.abc148

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    if (n % 2 == 1L) {
        println(0)
        return
    }
    var ans = 0L
    var bunbo = 2L
    while (n > bunbo) {
        bunbo *= 5
        ans += n / bunbo
    }
    println(ans)
}