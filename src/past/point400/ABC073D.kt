package past.point400


//ワーシャルフロイド,組み合わせ全通り(Permutation)
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
    val (n, m, r) = readLine()!!.split(' ').map(String::toInt)
    val rList = readLine()!!.split(' ').map(String::toInt)
    val costMap = Array(n + 1) { LongArray(n + 1) { Long.MAX_VALUE / 3 } }
    (1..m).forEach {
        val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
        costMap[a][b] = c.toLong()
        costMap[b][a] = c.toLong()
    }
    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                costMap[j][k] = Math.min(costMap[j][k], costMap[j][i] + costMap[i][k])
            }
        }
    }

}
