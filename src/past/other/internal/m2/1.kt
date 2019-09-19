package past.other.internal.m2

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val aSet = aList.toSet()
    if (aList.size == aSet.size) {
        println("YES")
    } else {
        println("NO")
    }
}
