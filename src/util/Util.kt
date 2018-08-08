package util

//コピペ用ライブラリ
import kotlin.system.measureTimeMillis
import java.util.Arrays
import java.util.Comparator
import java.util.PriorityQueue


fun input() {
    val s = readLine()!!
    val i = readLine()!!.toInt()
    val l = readLine()!!.toLong()
    val iList = readLine()!!.split(' ').map(String::toInt)
    val lList = readLine()!!.split(' ').map(String::toLong)

    val iGrid = mutableListOf<List<Int>>()
    for (i in 0 until i) {
        iGrid.add(readLine()!!.split(' ').map(String::toInt))
    }
}

fun countTime(args: Array<String>) {
    val time = measureTimeMillis {
        println(getPrimeList(1000000).size)
    }
    println("time:$time")
}

//素数判定用
fun isPrime(x: Int): Boolean {
    var i = 2
    while (i * i <= x) {
        if (x % i == 0) return false
        i++
    }
    return true
}

//素数判定用
fun getPrimeList(max: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    (2..max).filter { i ->
        (2..Math.sqrt(i.toDouble()).toInt()).all { i % it != 0 }
    }.forEach { list.add(it) }
    return list
}

//階乗を計算する。
fun calcFactorial(i: Long, modNum: Long? = null): Long {
    return if (i == 1L) {
        1
    } else if (modNum != null) {
        (i * calcFactorial(i - 1, modNum)) % modNum
    } else {
        i * calcFactorial(i - 1)
    }
}

//nCrを計算する
fun calcCombination(n: Int, r: Int): Long {
    var temp = 1.0
    for (i in 0..(r - 1)) {
        temp = temp * (n - i) / (r - i)
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

class DijkstraMatrix(n: Int) {
    var a: Array<IntArray>
    var b: BooleanArray
    var q: PriorityQueue<IntArray>

    init {
        a = Array(n + 1) { IntArray(n + 1) }
        b = BooleanArray(n + 1)
        q = PriorityQueue(n + 1, Comparator { o1, o2 -> o1[1] - o2[1] })
    }

    fun set(i: Int, j: Int, cost: Int) {
        a[i][j] = cost
    }

    fun getCost(s: Int, e: Int): Int {
        Arrays.fill(b, false)
        q.clear()
        b[s] = true
        for (i in 1 until a.size)
            if (a[s][i] > 0)
                q.add(intArrayOf(i, a[s][i]))
        var c = 0
        while (!q.isEmpty()) {
            val t = q.poll()
            if (t!![0] == e) {
                c = t[1]
                break
            }
            b[t[0]] = true
            for (i in 1 until a.size)
                if (!b[i] && a[t[0]][i] > 0)
                    q.add(intArrayOf(i, t[1] + a[t[0]][i]))
        }
        return c
    }
}