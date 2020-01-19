package participated.abc148

fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    println(arrayListOf(1, 2, 3).filter { it != a }.filter { it != b }[0])
}