package participated.ext011

fun main(args: Array<String>) {
    val mod = 1000000007L
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val internalReverse = (0 until n).map { i -> aList.takeLast(n.toInt() - i.toInt()).count { j -> j < aList[i.toInt()] }.toLong() }
    val allReverse = (0 until n).map { i -> aList.count { j -> j < aList[i.toInt()] }.toLong() }
    val internalReverseSum = internalReverse.sum()
    val allReverseSum = allReverse.sum()

    var ans = (internalReverseSum * k) % mod
    val x = (k * (k - 1) / 2) % mod
    ans += (allReverseSum * x) % mod
    ans %= mod

    println(ans)
}
