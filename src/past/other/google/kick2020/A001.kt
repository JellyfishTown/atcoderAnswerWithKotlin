package past.other.google.kick2020


fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 1..t) {
        val (n, b) = readLine()!!.split(' ').map(String::toInt)
        val aList = readLine()!!.split(' ').map(String::toInt).sorted()
        var sum = 0
        for (j in 0 until n) {
            sum += aList[j]
            if (sum > b) {
                println("Case #$i: $j")
                break
            }
            if (j == n - 1) println("Case #$i: $n")
        }
    }
}
