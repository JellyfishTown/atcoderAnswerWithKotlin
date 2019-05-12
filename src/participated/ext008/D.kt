package participated.ext008


fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    var total = 0L
    for (x in 1..1000000) {
        if (n % x == 0L) {
            val m = n / x - 1
            if (m <= 1 ||x >= m) break
            total += m
        }
    }
    println(total)
}
