package past.point300


fun main(args: Array<String>) {
    val (n, t) = readLine()!!.split(' ').map(String::toLong)
    val tList = readLine()!!.split(' ').map(String::toLong)

    var result = 0L
    for (i in 0 until (tList.size - 1)) {
        result += Math.min(t, tList[i + 1] - tList[i])
    }
    println(result + t)
}
