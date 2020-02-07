package participated.abc152

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toInt)
    var min = Int.MAX_VALUE
    var count = 0
    for (p in pList) {
        if (min >= p) {
            min = p
            count++
        }
    }
    println(count)
}