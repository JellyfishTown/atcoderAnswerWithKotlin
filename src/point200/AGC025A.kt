package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var min = Int.MAX_VALUE
    for (i in 1..(n-1)) {
        val temp = sumDigit(i) + sumDigit(n - i)
        min = Math.min(min,temp)
    }
    println(min)
}

fun sumDigit(num: Int): Int {
    val str = num.toString()
    var sum = 0
    str.forEach { sum += it.toString().toInt() }
    return sum
}