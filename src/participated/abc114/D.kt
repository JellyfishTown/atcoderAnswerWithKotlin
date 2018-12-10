package participated.abc114

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pfMap = mutableMapOf<Int, Map<Int, Int>>()
    (2..100).forEach { pfMap[it] = calcFactors(it) }

    val pfCountMap = mutableMapOf<Int, Int>()
    pfMap.filter { it.key <= n }.forEach {
        it.value.forEach { vit ->
            pfCountMap[vit.key] = vit.value + if (pfCountMap.containsKey(vit.key)) pfCountMap[vit.key]!! else 0
        }
    }

    val count2 = pfCountMap.count { it.value >= 2 }
    val count4 = pfCountMap.count { it.value >= 4 }
    val count14 = pfCountMap.count { it.value >= 14 }
    val count24 = pfCountMap.count { it.value >= 24 }
    val count74 = pfCountMap.count { it.value >= 74 }

    print(count74
            + count24 * count2 - count24
            + count14 * count4 - count14
            + count4 * (count4 - 1) * (count2 - 2) / 2)

}


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