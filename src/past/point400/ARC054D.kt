package past.point400

fun main(args: Array<String>) {
    fun calcFactors(n: Int): Map<Int, Int> {//素因数分解
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
        return factors
    }

    fun calcCombination(n: Long, r: Long, modNum: Long = 1L): Long {
        val tr = if (n - r < r) n - r else r
        if (tr == 0L) return 1
        if (tr == 1L) return n
        val numerator = (0 until r).map { n - tr + it + 1 }.toMutableList()
        val denominator = (0 until r).map { it + 1 }.toMutableList()

        for (p in 2..tr.toInt()) {
            val pivot = denominator[p - 1]
            if (pivot > 1) {
                val offset = (n - tr) % p
                for (k in p - 1 until r step p.toLong()) {
                    numerator[(k - offset).toInt()] /= pivot
                    denominator[k.toInt()] /= pivot
                }
            }
        }
        var result = 1L
        for(k in 0 until r){
            if(numerator[k.toInt()]>1){
                result *= numerator[k.toInt()]
                result %= modNum

            }
        }
        return result
    }

    val mod = 1000000007L
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val factors = calcFactors(m.toInt())

    var ans = 1L
    for ((key, value) in factors) {
        ans *= calcCombination(value + n - 1, value.toLong(), mod)
        ans %= mod
    }
    println(ans)
}
