package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    pList.add(0, 0)
    var count = 0
    var conti = 0
    for (i in 1..n) {
        if (conti == 1) {
            count++
            conti = 0
        } else if (i == pList[i]) {
            conti = 1
        }
    }
    if (conti == 1) count++
    println(count)
}
