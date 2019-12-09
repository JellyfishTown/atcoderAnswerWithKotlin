package participated.abc147

fun main(args: Array<String>) {
    val mod = 1000000007L
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val allsum = aList.sum()
    val allans = allsum * (n - 1)
    var allxor = 0L
    for (a in aList) {
        allxor = allxor xor a
    }
    var ans = 0L
    for (a in aList) {
//        ans += a xor (allsum - a)
        ans += a xor allxor
        ans %= mod
    }
    println((allans - ans) % mod)
}