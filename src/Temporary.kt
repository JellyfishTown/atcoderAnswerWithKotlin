fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val mod = 1000000007
    val factors = calcFactors(m)
    val combCalculator = Combination(n + factors.values.sum(), mod)
    var ans = 1
    factors.values.forEach { ans = (ans * combCalculator.calc(n + it - 1, it) % mod).toInt() }
    println(ans)
}

fun calcFactors(n: Int): Map<Int, Int> {
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

class Combination(n: Int, private val mod: Int) {
    private val fact = LongArray(n + 1)
    private val inv = LongArray(n + 1)
    private val invFact = LongArray(n + 1)

    init {
        inv[1] = 1
        for (i in 2 until inv.size) {
            inv[i] = inv[mod % i] * (mod - mod / i) % mod
        }

        fact[0] = 1
        invFact[0] = 1
        for (i in 1 until inv.size) {
            fact[i] = i * fact[i - 1] % mod
            invFact[i] = inv[i] * invFact[i - 1] % mod
        }
    }

    fun calc(n: Int, r: Int): Long {
        return if (n < r) 0 else fact[n] * invFact[n - r] % mod * invFact[r] % mod
    }
}
