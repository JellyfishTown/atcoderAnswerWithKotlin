package participated.agc029

fun main(args: Array<String>) {
    val (h, w, n) = readLine()!!.split(' ').map(String::toLong)
    val hwList = mutableListOf<Pair<Long, Long>>()
    for (i in 1..n) {
        val (ht, wt) = readLine()!!.split(' ').map(String::toLong)
        if (wt <= ht) hwList.add(Pair(ht, wt))
    }
    hwList.sortBy { it.second }
    hwList.sortBy { it.first }
    var diff = 1L
    var min = Long.MAX_VALUE
    for (i in 0 until hwList.size) {
        val h = hwList[i].first
        val w = hwList[i].second
        if (w + diff <= h) {
            min = Math.min(h - 1, min)
        } else if (h - w == diff - 1) {
            diff++
        }
    }
    print(Math.min(h, min))
}

