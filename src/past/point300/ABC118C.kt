fun main(args: Array<String>) {
    val n= readLine()!!.toLong()
    val a = readLine()!!.split(" ").map(String::toLong)
    println(gcd2(a))
}

fun gcd1(a: Long, b: Long): Long {
    return if (b > 0) gcd1(b, a % b) else a
}

fun gcd2(param: List<Long>): Long {
    var g = gcd1(param[0], param[1])
    for (i in 2 until param.size) g = gcd1(g, param[i])
    return g
}
