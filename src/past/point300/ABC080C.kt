package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val fList = mutableListOf<List<Int>>()
    val pList = mutableListOf<List<Int>>()
    val oList = mutableListOf<List<Int>>()
    for (i in 1..n) {
        fList.add(readLine()!!.split(" ").map(String::toInt))
    }
    for (i in 1..n) {
        pList.add(readLine()!!.split(" ").map(String::toInt))
    }
    (1..1023).forEach { i ->
        run {
            oList.add(String.format("%010d", Integer.toBinaryString(i).toInt()).split("").filter { it.isNotEmpty() }.map(String::toInt))
        }
    }

    var max = Long.MIN_VALUE
    for (own in oList) {
        var benefit = 0L
        fList.forEachIndexed { index, list ->
            run {
                var both = 0
                for (i in 0..9) {
                    if (own[i] == 1 && list[i] == 1) both++
                }
                benefit += pList[index][both]
            }
        }
        max = Math.max(max, benefit)
    }
    println(max)
}
