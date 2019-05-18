package past.point400


fun main(args: Array<String>) {
    readLine()!!.toInt()
    val a = readLine()!!.split(" ").map(String::toLong)
    val sum = a.map { Math.abs(it) }.sum()
    val min = Math.abs(a.minBy { Math.abs(it) }!!)
    val hasMinus = a.count { it < 0 } % 2 == 1
    println(if (hasMinus) sum - min * 2 else sum)
}
