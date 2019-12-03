package past.point400

fun main(args: Array<String>) {
    val (n, t) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt)
    val lMax = IntArray(n)
    lMax[n - 1] = aList[n - 1]
    ((n - 2) downTo 0).forEach { lMax[it] = Math.max(lMax[it + 1], aList[it]) }
    val diffMap = mutableMapOf<Int, Int>()
    ((n - 1) downTo 0).forEach {
        val diff = lMax[it] - aList[it]
        diffMap[diff] = (diffMap[diff] ?:0) + 1
    }
    val maxKey = diffMap.keys.max()
    println(diffMap[maxKey])
}
