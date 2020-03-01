package participated.abc155

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong).filter { it % 2 == 0L }
    if (aList.filter { it % 3 != 0L && it % 5 != 0L }.size > 0) {
        println("DENIED")
    } else {
        println("APPROVED")
    }
}
