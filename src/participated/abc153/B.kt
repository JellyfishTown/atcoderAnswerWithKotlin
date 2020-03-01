package participated.abc153

fun main(args: Array<String>) {
    val (h, a) = readLine()!!.split(' ').map(String::toDouble)
    val aList = readLine()!!.split(' ').map(String::toLong)
    if (aList.sum()>=h) {
        println("Yes")
    } else {
        println("No")
    }
}