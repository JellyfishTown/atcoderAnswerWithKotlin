package util

fun getPrimeListByEratosthenes(maxValue: Int): BooleanArray {
    val isPrime = BooleanArray(maxValue + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    val root = Math.sqrt(maxValue.toDouble()).toInt() + 1
    for (i in 2..root) {
        if (isPrime[i]) {
            var j = i * 2
            while (j < maxValue) {
                isPrime[j] = false
                j += i
            }
        }
    }
    return isPrime
}

fun isPrimeFast(num: Long): Boolean {
    if (num < 2)
        return false
    else if (num == 2L)
        return true
    else if (num % 2L == 0L)
        return false
    val sqrtNum = Math.sqrt(num.toDouble())
    var i = 3
    while (i <= sqrtNum) {
        if (num % i == 0L) {
            return false
        }
        i += 2
    }
    return true
}
