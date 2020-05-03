package participated.abc163

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    val day = aList.sum()
    if (day > n) {
        println(-1)
    } else {
        println(n - day)
    }
}
