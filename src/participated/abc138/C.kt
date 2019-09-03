package participated.abc138

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val vList = readLine()!!.split(' ').map(String::toDouble).sorted()
    var ans = vList[0]
    for (i in 1 until n) {
        ans = (ans + vList[i]) / 2.0
    }
    println(ans)
}
