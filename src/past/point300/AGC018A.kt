fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toLong)
    val aList = readLine()!!.split(" ").map(String::toLong)
    val gcd = gcd(aList)
    if (k % gcd == 0L && aList.max()?:0 >= k) {
        println("POSSIBLE")
    } else {
        println("IMPOSSIBLE")
    }
}

fun gcd(a: Long, b: Long): Long {
    return if (b > 0) gcd(b, a % b) else a
}

fun gcd(param: List<Long>): Long {
    var g = gcd(param[0], param[1])
    for (i in 2 until param.size) g = gcd(g, param[i])
    return g
}