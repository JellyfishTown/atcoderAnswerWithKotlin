package util

//最大公約数
fun gcd(a: Long, b: Long): Long {
    return if (b > 0) gcd(b, a % b) else a
}

//最大公約数

fun gcd(param: List<Long>): Long {
    var g = gcd(param[0], param[1])
    for (i in 2 until param.size) g = gcd(g, param[i])
    return g
}
