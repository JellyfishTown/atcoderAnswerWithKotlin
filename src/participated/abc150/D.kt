package participated.abc150

fun main(args: Array<String>) {
    fun gcd(a: Long, b: Long): Long {
        return if (b > 0) gcd(b, a % b) else a
    }

    fun lcm(a: Long, b: Long): Long {
        return a * b / gcd(a, b)
    }

    fun lcm(param: List<Long>): Long {
        if (param.size == 1) return param[0]
        var l = lcm(param[0], param[1])
        for (i in 2 until param.size) l = lcm(l, param[i])
        return l
    }
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong).distinct()


    val map = aList.map {
        var ts = 2L
        while (it % ts == 0L) ts *= 2
        ts
    }
    if (map.distinct().size != 1) {
        println(0)
        return
    }

    val lcm = lcm(aList.map { it / 2 })
    println(Math.round(m.toDouble() / lcm.toDouble() / 2.0))
}