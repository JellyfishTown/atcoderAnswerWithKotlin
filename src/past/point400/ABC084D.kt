package past.point400

//素数 累積和
fun main(args: Array<String>) {
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

    val q = readLine()!!.toInt()
    val maxValue = 100000
    val isPrime = getPrimeListByEratosthenes(maxValue)
    val spCount = IntArray(maxValue + 1) { 0 }
    (1..maxValue).forEach { spCount[it] = spCount[it - 1] + if (it % 2 == 1 && isPrime[it] && isPrime[(it + 1) / 2]) 1 else 0 }
    (1..q).forEach {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        println(spCount[r] - spCount[l - 1])
    }
}
