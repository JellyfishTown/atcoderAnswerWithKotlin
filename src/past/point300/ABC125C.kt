fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map(String::toLong)

    val l1 = mutableListOf(a.first())
    val l2 = mutableListOf(a.last())
    a.forEach { l1.add(gcd125(it, l1.last())) }
    a.reversed().forEach { l2.add(0, gcd125(it, l2.first())) }
    l1.removeAt(0)
    l2.removeAt(l2.size-1)

    var max = Math.max(l1[l1.size - 2], l2[1])
    (1 until n - 1).forEach { max = Math.max(max, gcd125(l1[it - 1], l2[it + 1])) }
    println(max)
}

fun gcd125(a: Long, b: Long): Long = if (b > 0) gcd125(b, a % b) else a

