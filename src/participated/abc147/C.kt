package participated.abc147

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    fun toBinaryNumberCharArray(num: Long): String {
        return String.format("%0${n}d", java.lang.Long.toBinaryString(num).toLong())
    }

    val axy = Array(n) { mutableListOf<Pair<Int, Int>>() }
    (0 until n).forEach {
        val a = readLine()!!.toInt()
        for (i in 1..a) {
            val (x, y) = readLine()!!.split(' ').map(String::toInt)
            axy[it].add(Pair(x, y))
        }
    }
    var flag = (1L shl n) - 1L
    while (flag >= 0) {
        val sf = toBinaryNumberCharArray(flag)
        var index = 0
        var check = true
        for (c in sf) {
            if (c == '1') {
                val syo = axy[index]
                for (xy in syo) {
                    val (x, y) = xy
                    if (sf[x - 1].toString() != y.toString()) check = false
                }
            }
            index++
        }
        if (check) {
            println(sf.count { it == '1' })
            return
        }
        flag--
    }
    println(0)
}