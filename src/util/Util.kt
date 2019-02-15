package util

//コピペ用ライブラリ


fun input() {
    val s = readLine()!!
    val n = readLine()!!.toInt()
    val l = readLine()!!.toLong()
    val (a,b) = readLine()!!.split(' ').map(String::toLong)
    val lList = readLine()!!.split(' ').map(String::toLong)

    val iGrid = mutableListOf<List<Int>>()
    for (i in 1..n) {
        iGrid.add(readLine()!!.split(' ').map(String::toInt))
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

//nCrを計算する
fun calcCombination(n: Long, r: Long, modNum: Long = 1L): Long {
    var temp = 1.0
    for (i in 0..(r - 1)) {
        temp = (temp % modNum) * (n - i) / (r - i)
    }
    return temp.toLong()
}

//与えられたArrayの全ての組み合わせを返す
class Permutation<T> private constructor(private val baseIndex: Int, private var index: Int, val target: Array<T>?) {
    private var subPermutation: Permutation<T>? = null

    constructor(objs: Array<T>) : this(0, 0, objs.clone())

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

inline fun <T> List<T>.fastIndexOfLast(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    while (left < right) {
        val index = ((left + right) / 2)
        if (predicate(this[index])) {
            left = index + 1
        } else {
            right = index
        }
    }
    return if (predicate(this[left])) {
        left
    } else {
        left - 1
    }
}

inline fun <T> List<T>.fastIndexOfFirst(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    var allFalse = true
    while (left < right) {
        val index = ((left + right) / 2)
        if (predicate(this[index])) {
            right = index
            allFalse = false
        } else {
            left = index + 1
        }
    }
    return when {
        predicate(this[left]) -> left
        allFalse -> return -1
        else -> left - 1
    }
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
