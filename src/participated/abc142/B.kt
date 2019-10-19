package participated.abc142

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val hList = readLine()!!.split(' ').map(String::toLong)
    println(hList.count { it >= k })
}