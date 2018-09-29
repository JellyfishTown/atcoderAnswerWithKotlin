fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<Long>()
    val bList = mutableListOf<Long>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        aList.add(a)
        bList.add(b)
    }
    var count = 0L
    for (i in n - 1 downTo 0) {
        val temp = (aList[i] + count) % bList[i]
        val v = if (temp == 0L) 0 else (bList[i] - temp)
        count += v
    }
    println(count)
}

