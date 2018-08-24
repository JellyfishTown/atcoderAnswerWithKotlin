package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<List<Int>>()
    aList.add(readLine()!!.split(' ').map(String::toInt))
    aList.add(readLine()!!.split(' ').map(String::toInt))

    var max = 0
    for (i in 0 until n) {
        val temp = aList[0].filterIndexed { index, it -> index <= i }.sum() +
                aList[1].filterIndexed { index, it -> index >= i }.sum()
        max = Math.max(max, temp)
    }
    println(max)
}