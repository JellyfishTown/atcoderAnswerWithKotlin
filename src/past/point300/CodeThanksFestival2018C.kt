fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val x = readLine()!!.split(" ").map(String::toLong).sorted()
    var sum = 0L

    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            sum += x[j] - x[i]
        }
    }
    println(sum)
}

