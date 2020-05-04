package participated.abc165

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val array = IntArray(n + 1) { 0 }
    array[0] = 1
    for (i in 1..k) {
        val d = readLine()!!
        val aList = readLine()!!.split(' ').map(String::toInt)
        aList.forEach { array[it]++ }
    }
    println(array.count { it == 0 })
}
