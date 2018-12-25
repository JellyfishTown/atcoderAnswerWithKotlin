package participated.ext001

//https://atcoder.jp/contests/caddi2018
fun main(args: Array<String>) {
    var (n, p) = readLine()!!.split(' ').map(String::toLong)
    val factors = calcFactors(p)
    var filterd = factors.filter { it.value >= n }

    if (filterd.isEmpty()) {
        println(1)
    } else {
        var total = 1L
        var x = 2L
        while (filterd.isNotEmpty()) {
            filterd.forEach { total *= it.key }
            filterd = filterd.filter { it.value >= n * x }
            x++
        }
        println(total)
    }
}

fun calcFactors(n: Long): Map<Long, Long> {//素因数分解
    val factors = mutableMapOf<Long, Long>()
    var tmp = n
    var i = 2L
    while (i * i <= tmp) {
        while (tmp % i == 0L) {
            factors[i] = factors.getOrElse(i) { 0L } + 1L
            tmp /= i
        }
        i++
    }
    if (tmp > 1L) factors[tmp] = 1L
    return factors
}