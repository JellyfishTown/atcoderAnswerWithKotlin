package past.point400

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val tdList = (1..n).map {
        val (t, d) = readLine()!!.split(' ').map(String::toLong)
        Pair(t, d)
    }

}
