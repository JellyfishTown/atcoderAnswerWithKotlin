package past.point300

fun main(args: Array<String>) {
    fun calcFactorNum(n: Int): Int{
        val factors = mutableMapOf<Int, Int>()
        var tmp = n
        var i = 2
        while (i * i <= tmp) {
            while (tmp % i == 0) {
                factors[i] = factors.getOrElse(i) { 0 } + 1
                tmp /= i
            }
            i++
        }
        if (tmp > 1) factors[tmp] = 1
        return factors.map { it.value }.sum()
    }
    readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val facList = aList.map { calcFactorNum(it) }

    val reduce = facList.reduce { acc, i -> acc xor i }
    if (reduce == 0) {
        println("No")
    } else {
        println("Yes")
    }
}
