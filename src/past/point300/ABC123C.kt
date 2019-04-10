fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    var min = Long.MAX_VALUE
    (1..5).forEach { min = Math.min(readLine()!!.toLong(), min) }
    println(4 + Math.ceil(n.toDouble() / min.toDouble()).toLong())
}
