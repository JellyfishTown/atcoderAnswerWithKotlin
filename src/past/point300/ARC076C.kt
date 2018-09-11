package past.point300


fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val modNum = 1000000007L

    val subtract = Math.abs(n - m)
    when {
        subtract >= 2 -> {
            println(0)
            return
        }
        subtract == 1L -> {
            val larger = Math.max(n, m)
            println((calcFactorial(larger, modNum) * calcFactorial(larger - 1, modNum)) % modNum)
            return
        }
        else -> {
            println((calcFactorial(n, modNum) * calcFactorial(m, modNum) * 2) % modNum)
            return
        }
    }
}

fun calcFactorial(input: Long, modNum: Long): Long {
    var result = 1L
    for (i in 1L..input) {
        result = (result * i) % modNum
    }
    return result
}