package participated.agc028

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val s = readLine()!!
    val t = readLine()!!
    val kobai = n * m / gcd(n, m)
    val xs = mutableMapOf<Long, Char>()
    s.forEachIndexed { index, c ->
        xs[index * kobai / n + 1] = c
    }
    t.forEachIndexed { index, c ->
        if ((xs[index * kobai / m + 1]?.equals(c)?.not() == true)) {
            println(-1)
            return
        }
    }
    println(kobai)


}

fun gcd(a: Long, b: Long): Long {
    return if (b > 0) gcd(b, a % b) else a
}