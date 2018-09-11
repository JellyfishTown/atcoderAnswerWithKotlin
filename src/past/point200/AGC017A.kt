package past.point200

fun main(args: Array<String>) {
    val (n, p) = readLine()!!.split(" ").map(String::toInt)
    val aList = readLine()!!.split(" ").map(String::toInt)

    val oddNum = aList.count { it % 2 == 1 }
    val evenNum = aList.count { it % 2 == 0 }

    var ans = 0L

    for (i in 0..evenNum) {
        val ic = comb(evenNum, i)
        for (j in 0..oddNum) {
            if (j % 2 == p) ans += ic * comb(oddNum, j)
        }
    }
    println(ans)
}

private fun comb(n: Int, r: Int): Long {
    var r = r
    if (n < 0 || r < 0 || n < r) {
        return 0
    }
    if (r > n / 2) {
        r = n - r
    }
    var ans = 1.0
    for (i in 0..(r - 1)) {
        ans = ans * (n - (r - 1) + i) / (i + 1)
    }
    return ans.toLong()
}