package participated.abc137

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = mutableListOf<String>()
    (1..n).forEach { sList.add(readLine()!!.toCharArray().sorted().joinToString("")) }
    sList.sort()

    var ans = 0L
    var c = 1L
    for (i in 0 until n - 1) {
        if (sList[i] == sList[i + 1]) {
            ans += c
            c++
        } else {
            c = 1L
        }
    }
    println(ans)
}
