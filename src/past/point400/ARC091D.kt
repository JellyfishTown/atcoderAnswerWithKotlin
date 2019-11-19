package past.point400

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    var ans = 0L
    if (k == 0L) {
        println(n * n)
        return
    }
    for (b in (k + 1)..n) {
        val last = n % b
        val countK = Math.min(n / b + if (last >= k) 1 else 0, n)
        val leftSmaller = countK * k - 1
        val rightSmaller = if (last < k) last + 1 else 0
        val smaller = leftSmaller + rightSmaller
        ans += n - smaller
    }
    println(ans)
}
