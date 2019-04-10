package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toLong).sorted()
    val aSumList = mutableListOf(aList[0])
    (1 until n).forEach { aSumList.add(aList[it] + aSumList[it - 1]) }
    for (i in n - 1 downTo 1) {
        if (aList[i]> aSumList[i - 1] * 2){
            println(n-i)
            return
        }
    }
    println(n)
}
