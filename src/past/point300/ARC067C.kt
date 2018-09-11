package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val soinsu = mutableMapOf<Int, Int>()
    for (i in 2..n) {
        var temp = i
        var j = 2
        while (j <= n) {
            if (temp % j == 0) {
                soinsu[j] = (soinsu[j] ?: 0) + 1
                temp /= j
            } else {
                j = if (j == 2) j + 1 else j + 2
            }
            if (temp == 1) break
        }
    }
    var answer = 1L
    for ((k, v) in soinsu) {
        answer *= v + 1
        answer %= 1000000007
    }
    println(answer)
}
