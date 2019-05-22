package participated.ext007

//https://atcoder.jp/contests/tenka1-2019
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<Long>()
    (1..n).forEach { aList.add(readLine()!!.toLong()) }
    val a0 = readLine()!!.toLong()
    val primeList = getPrimeListByEratosthenes(1000)

    for (i in 2..a0.toInt()) {
        if (primeList[i]) {
            if (n == 0) {
                println(i)
            } else {
                var ok = true
                for (a in aList) {
                    if (i % a != 0L) ok = false
                }
                if (ok) println(i)
            }
        }
    }
}

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