package past.point300

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    var before = aList.first()
    var answer = 0L
    if (before > x) {
        answer += before - x
        before = x
    }

    for (i in 1 until n.toInt()) {
        if (before + aList[i] > x) {
            val sub = before + aList[i] - x
            answer += sub
            before = aList[i] - sub
        }else{
            before = aList[i]
        }
    }
    println(answer)
}