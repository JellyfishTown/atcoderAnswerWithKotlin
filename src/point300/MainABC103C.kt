package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    println(aList.sum() - n)
}

