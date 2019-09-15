package participated.abc140

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val max = sList.max()!!
    if (sList.filter { it == max }.size >= 2) {
        println("No")
        return
    }
    val ceils = Array(sList.size) { 0L }
    ceils[0] = max
    var ts = 1
    repeat(n) {
        for (i in 0 until ts) {
            ceils[i + ts] = ceils[i] - 1
        }
        ts *= 2
    }
    ceils.sortDescending()
    if ((0 until sList.size).all { sList[it] <= ceils[it] }.not()) {
        println("No")
        return
    }
    println("Yes")
}