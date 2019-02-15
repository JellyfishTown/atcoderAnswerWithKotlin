fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val r = readLine()!!.split(" ").map(String::toInt)
    val f = DoubleArray(n + 1)
    for (i in 2..n) {
        f[i] += f[i - 1] + Math.log10(i.toDouble())
    }
    var d = f[n] - Math.log10(m.toDouble()) * n
    for (i in 0 until m) {
        d -= f[r[i]]
    }
    println(Math.abs(Math.floor(d)).toLong())
}
