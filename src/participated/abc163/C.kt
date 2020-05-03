package participated.abc163

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    aList.add(0, 0)
    aList.add(0, 0)
    val bukaNum = IntArray(n + 1)
    for(a in aList)bukaNum[a]++
    for (i in 1..n) {
        println(bukaNum[i])
    }
}
