package participated.abc160

fun main(args: Array<String>) {
    val (x, y, a, b, c) = readLine()!!.split(' ').map(String::toLong)
    val pList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val qList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val rList = readLine()!!.split(' ').map(String::toLong).sortedDescending()

    var eatList = pList.take(x.toInt()) + qList.take(y.toInt())
    eatList = eatList.sorted()
    var sum = eatList.sum()
    for (i in 0 until c.toInt()) {
        if (eatList[i] < rList[i]) {
            sum -= eatList[i]
            sum += rList[i]
        } else {
            break
        }
    }
    println(sum)
}
