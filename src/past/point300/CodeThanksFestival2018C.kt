fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val x = readLine()!!.split(" ").map(String::toLong).sorted()
    var total = x.map { it - x[0] }.sum()
    var sum = total
    for (i in 1 until n) {
        val diff = x[i] - x[i - 1]
        total = total + diff * i - diff * (n - i)
        sum += total
    }
    println(sum / 2)
}

