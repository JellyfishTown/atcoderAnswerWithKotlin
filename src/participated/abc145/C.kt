package participated.abc145

fun main(args: Array<String>) {
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

    fun calcFactorial(i: Long, modNum: Long? = null): Long {
        return when {
            i == 1L -> 1L
            modNum != null -> (i * calcFactorial(i - 1, modNum)) % modNum
            else -> i * calcFactorial(i - 1)
        }
    }

    fun calcDist(one: Pair<Double, Double>, two: Pair<Double, Double>) = Math.sqrt(Math.pow(one.first - two.first, 2.0) + Math.pow(one.second - two.second, 2.0))
    val n = readLine()!!.toInt()
    val xyList = mutableListOf<Pair<Double, Double>>()
    (1..n).forEach {
        val (x, y) = readLine()!!.split(' ').map(String::toDouble)
        xyList.add(Pair(x, y))
    }
    val distMap = Array(n) { Array(n) { 0.0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            distMap[i][j] = calcDist(xyList[i], xyList[j])
        }
    }

    val pattern = listOf(0, 1, 2, 3, 4, 5, 6, 7).subList(0, n).toTypedArray()
    val permutation = Permutation(pattern)
    var distSum = 0.0
    do {
        val target = permutation.target!!

        for (i in 0..(n - 2)) {
            distSum += distMap[target[i]][target[i + 1]]
        }

    } while (permutation.next())
    println(distSum / calcFactorial(n.toLong()).toDouble())
}


