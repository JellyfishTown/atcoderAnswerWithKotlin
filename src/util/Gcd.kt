package util

//最大公約数
fun gcd(a: Long, b: Long): Long {
    return if (b > 0) gcd(b, a % b) else a
}

fun gcd(param: List<Long>): Long {
    if (param.size == 1) return param[0]
    var g = gcd(param[0], param[1])
    for (i in 2 until param.size) g = gcd(g, param[i])
    return g
}
//最小公倍数
fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
}

fun lcm(param: List<Long>): Long {
    if (param.size == 1) return param[0]
    var l = lcm(param[0], param[1])
    for (i in 2 until param.size) l = lcm(l, param[i])
    return l
}