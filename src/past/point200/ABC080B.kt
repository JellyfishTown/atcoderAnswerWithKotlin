package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    println(if (n % sumK(n) == 0) "Yes" else "No")
}

fun sumK(num: Int): Int {
    val str = num.toString()
    var sum = 0
    str.forEach { sum += it.toString().toInt() }
    return sum
}


