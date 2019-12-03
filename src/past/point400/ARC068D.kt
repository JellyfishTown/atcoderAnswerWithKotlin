package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val max = aList.max()!!
    val map = IntArray(max+1) { 0 }
    aList.forEach { map[it]++ }
    (1..max).forEach { map[it] = Math.max(map[it] - 1, 0) }
    val sum = map.sum()
    if (sum % 2 == 0) {
        println(n - sum)
    } else {
        println(n - sum - 1)
    }
}
