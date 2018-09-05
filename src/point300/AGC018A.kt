fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toLong)
    val aList = readLine()!!.split(" ").map(String::toLong)
    val gcd = gcd(aList)
    if (k % gcd == 0L && aList.max()!! >= k){
        println("POSSIBLE")
    }else{
        println("IMPOSSIBLE")
    }

}

fun gcd(a: Long, b: Long): Long {
    var a = a
    var b = b
    if (a < b) {
        val tmp = a
        a = b
        b = tmp
    }
    var r = -1L
    while (r != 0L) {
        r = a % b
        a = b
        b = r
    }
    return a
}

fun gcd(param: List<Long>): Long {
    val len = param.size
    var g = gcd(param[0], param[1])
    for (i in 1 until len - 1) {
        g = gcd(g, param[i + 1])
    }
    return g
}