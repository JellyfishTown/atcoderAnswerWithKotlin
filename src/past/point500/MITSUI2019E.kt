package past.point500

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val mod = 1000000007L

    var ans = 1L
    val hat = IntArray(n + 1) { 0 }
    for (a in aList) {
        ans *= ((hat.getOrNull(a - 1) ?: 3) - hat[a])
        ans %= mod
        hat[a]++
    }
    println(ans)
}
