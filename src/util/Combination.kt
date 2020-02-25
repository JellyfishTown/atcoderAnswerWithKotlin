package util

class BulkCombination(n: Int, val mod: Long = 1000000007L) {

    private val factorial = LongArray(n + 1) { 1 }
    private val inverse = LongArray(n + 1) { 1 }
    private val factorialInverse = LongArray(n + 1) { 1 }

    init {
        for (i in 2..n) {
            factorial[i] = (factorial[i - 1] * i.toLong() % mod)
            inverse[i] = (mod - inverse[mod.toInt() % i] * (mod / i.toLong()) % mod)
            factorialInverse[i] = (factorialInverse[i - 1] * inverse[i] % mod)
        }
    }

    fun nCm(n: Int, m: Int): Long {
        return factorial[n] * (factorialInverse[m] * factorialInverse[n - m] % mod) % mod
    }

    fun nHm(n: Int, m: Int): Long {
        return nCm(n + m - 1, m)
    }
}

//階乗を計算する。
fun calcFactorial(i: Long, modNum: Long? = null): Long {
    return when {
        i == 1L -> 1L
        modNum != null -> (i * calcFactorial(i - 1, modNum)) % modNum
        else -> i * calcFactorial(i - 1)
    }
}

//与えられたArrayの全ての組み合わせを返す
class Permutation<T> private constructor(private val baseIndex: Int, private var index: Int, val target: Array<T>?) {
    private var subPermutation: Permutation<T>? = null

    init {
        if (target == null || target.isEmpty()) {
            throw IllegalArgumentException()
        }

        if (this.index < this.target.size - 1) {
            this.subPermutation = Permutation(this.baseIndex + 1, this.index + 1, this.target)
        }
    }

    operator fun next(): Boolean {
        if (this.subPermutation == null) {
            return false
        }
        val result = this.subPermutation!!.next()
        if (result) {
            return true
        }
        this.swap(this.baseIndex, this.index)
        ++this.index
        if (this.target!!.size <= this.index) {
            this.index = this.baseIndex
            return false
        }
        this.swap(this.index, this.baseIndex)
        return true
    }

    private fun swap(index1: Int, index2: Int) {
        val tmp = this.target!![index1]
        this.target[index1] = this.target[index2]
        this.target[index2] = tmp
    }
}


//return a^b mod M O(logB)
fun pow(a: Long, b: Long, mod: Long): Long {
    var bt = b
    var ret: Long = 1
    var tmp = a
    while (bt > 0) {
        if (bt and 1 == 1L) ret = ret * tmp % mod
        tmp = tmp * tmp % mod
        bt = bt shr 1
    }
    return ret
}

//return nCk mod mod (mod must be prime number) O(min(k,n-k)*logM)
fun nCk(n: Long, k: Long, mod: Long): Long {
    var ret: Long = 1
    val min = Math.min(k, n - k)
    for (i in 1..min) {
        ret = ret * pow(i, (mod - 2), mod) % mod
    }
    for (i in n - min + 1..n) {
        ret = ret * i % mod
    }
    return ret
}
