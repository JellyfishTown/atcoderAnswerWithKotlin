package point500

fun main(args: Array<String>) {
    var num = 0L
    var d = 1L
    for (i in 1..readLine()!!.toLong()) {
        if ((num + d).toDouble() / (num + d).toString().map { it.toString().toInt() }.sum().toDouble() >
                (num + 10 * d).toDouble() / (num + 10 * d).toString().map { it.toString().toInt() }.sum().toDouble()) d *= 10
        num += d
        println(num)
    }
}