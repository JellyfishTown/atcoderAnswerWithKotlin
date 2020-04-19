package participated.abc161

fun main(args: Array<String>) {
    fun calcFactors(n: Long): Map<Long, Int> {//素因数分解
        val factors = mutableMapOf<Long, Int>()
        var tmp = n
        var i = 2L
        while (i * i <= tmp) {
            while (tmp % i == 0L) {
                factors[i] = factors.getOrElse(i) { 0 } + 1
                tmp /= i
            }
            i++
        }
        if (tmp > 1) factors[tmp] = 1
        return factors
    }

    fun divisor(n: Long): List<Long> {
        val list = mutableListOf<Long>()
        var i = 1L
        while (i * i <= n) {
            if (n % i == 0L) {
                list.add(i)
                if (i != n / i) {
                    list.add(n / i)
                }
            }
            i++
        }
        return list.sortedDescending()
    }

    val n = readLine()!!.toLong()
    if (n == 2L) {
        println(1)
        return
    }

    val factors = calcFactors(n)
    val divisorOne = divisor(n - 1).toMutableList()

    if (factors.size == 1) {
        val key = factors.keys.first()
        val temp = factors.values.first()
        val tempDiv = divisor(temp.toLong())
        for (t in tempDiv) {
            divisorOne.add(Math.pow(key.toDouble(), t.toDouble()).toLong())
        }
    }
    divisorOne.add(n)
    divisorOne.add(n - 1)
    divisorOne.add(2)
    divisorOne.remove(1)
    println(divisorOne.toSet().size)

}
