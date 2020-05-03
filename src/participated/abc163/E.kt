package participated.abc163

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    aList.add(0, 0)
    val apList = (1..n).map { Pair(it, aList[it]) }.sortedByDescending { it.second }


    var l = 1
    var r = n
    var ans = 0L
    for (p in apList) {
        val (i, a) = p
        val la = aList[l]
        val ra = aList[r]
        val ldiff = Math.abs(l - i).toLong()
        val rdiff = Math.abs(r - i).toLong()
        val lVal = ldiff * a + ldiff * la
        val rVal = rdiff * a + rdiff * ra
        if (lVal > rVal) {
            ans += ldiff * a
            l++
        } else {
            ans += rdiff * a
            r--
        }
    }
    println(ans)
}
