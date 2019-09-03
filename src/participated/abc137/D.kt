package participated.abc137

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toLong)
    val abList = (1..n).map {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        Pair(a, b)
    }.sortedBy { it.first }


    var ans = 0L
    var bi = 0
    val workList = mutableListOf<Long>()
    for (i in 1..m) {
        while (bi != abList.size && abList[bi].first <= i) {
            val work = abList[bi].second
            var index = 0
            workList.run {
                if (this.size == 0) {
                    index = 0
                    return@run
                }
                var l = 0
                var r = this.size - 1
                while (l < r) {
                    val m = (l + r) / 2
                    if (this[m] < work) l = m + 1
                    else if (this[m] > work) r = m - 1
                    else {
                        index = m
                        return@run
                    }
                }
                val comp = this[l].compareTo(work)
                if (comp < 0) {
                    index = l + 1
                } else {
                    index = l
                }
            }

            workList.add(Math.min(index,workList.size), work)
            bi++
        }
        if (workList.isNotEmpty()) {
            ans += workList.removeAt(workList.size - 1)
        }
    }
    println(ans)
}

