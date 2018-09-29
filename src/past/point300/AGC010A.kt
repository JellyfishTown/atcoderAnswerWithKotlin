fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toInt)
    println(if (aList.count { it % 2 == 1 } % 2 == 0) "YES" else "NO")
}

