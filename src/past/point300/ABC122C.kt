fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map(String::toLong)
    val s = readLine()!!
    val total = LongArray(n.toInt() + 1) { 0L }
    for (i in 0 until (n.toInt() - 1)) {
        total[i + 1] = total[i] + if (s[i] == 'A' && s[i + 1] == 'C') 1 else 0
    }
    total[n.toInt()] = total[n.toInt() - 1]
    for (i in 1..q) {
        val (l, r) = readLine()!!.split(" ").map(String::toInt)
        println(total[r-1] - total[l-1])
    }
}
