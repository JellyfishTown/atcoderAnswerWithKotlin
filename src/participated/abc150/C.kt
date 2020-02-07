package participated.abc150

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

    val n = readLine()!!.toInt()
    val pList = readLine()!!.split(' ').map(String::toLong).joinToString("")
    val qList = readLine()!!.split(' ').map(String::toLong).joinToString("")

    val per = Permutation((1..n).toList().toTypedArray())
    val list = mutableListOf<String>()
    do {
        val s = per.target!!.joinToString("")
        list.add(s)
    } while (per.next())
    list.sort()

    println(Math.abs(list.indexOf(pList) - list.indexOf(qList)))
}