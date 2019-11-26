package past.point500

fun main(args: Array<String>) {
    val m = readLine()!!.toInt()
    var cSum = 0L
    var dSum = 0L
    (1..m).forEach {
        val (d, c) = readLine()!!.split(' ').map(String::toLong)
        cSum += c
        dSum += c * d
    }
    println(cSum - 1 + (dSum - 1) / 9)
}
