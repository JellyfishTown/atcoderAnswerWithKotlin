package participated.abc129
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val wList = readLine()!!.split(' ').map(String::toLong)
    var min = Long.MAX_VALUE
    for (i in 1..n) {
        val sa = Math.abs(wList.take(i).sum() - wList.takeLast(n - i).sum())
        min = Math.min(min, sa)
    }

    println(min)
}