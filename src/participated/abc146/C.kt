package participated.abc146

fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(' ').map(String::toLong)
    var ans = 0L
    fun checkCanBuy(i: Long): Boolean {
        val iKeta = i.toString().length.toLong()
        val l = a * i + b * iKeta
//        println("$i $l ${l<=x}")
        return l <= x
    }

    var goalIndex = 1L shl 30
    for (i in 29 downTo 0) {
        val diff = 1L shl i
        val currentIndex = goalIndex - diff
        if (checkCanBuy(currentIndex)) {
            ans = currentIndex
        }else{
            goalIndex -= diff
        }
    }
    println(Math.min(ans, 1000000000L))
}