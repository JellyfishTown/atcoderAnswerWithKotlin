package participated.abc132

fun main(args: Array<String>) {
    val mod = 1000000007L
    val ncr = Array(2001) { LongArray(2001){0} }
    ncr[0][0] = 1
    for (i in 1..2000) {
        ncr[i][0] = 1
        for (j in 1..i) {
            ncr[i][j] = (ncr[i - 1][j - 1] + ncr[i - 1][j]) % mod
        }
    }
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    for (i in 1..k) {
        println(ncr[k - 1][i - 1] * ncr[n - k + 1][i] % mod)
    }
}
