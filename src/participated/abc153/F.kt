package participated.abc153

fun main(args: Array<String>) {

    val (n, d, a) = readLine()!!.split(' ').map(String::toLong)
    val ad = a.toDouble()
    val xhList = mutableListOf<Pair<Long, Long>>()
    (1..n).forEach {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        xhList.add(Pair(a, b))
    }
    val damageList = mutableListOf<Pair<Long, Long>>()
    xhList.sortBy { it.first }
    for (xh in xhList) {
        val (x, h) = xh
        var totalDamage = 0L
        for (damage in damageList) {
            val (r, times) = damage
            if (r in x-d..x+d) totalDamage += times * a
        }
        if (totalDamage > h) continue
        val right = x + 2 * d
        damageList.add(Pair(right, ((h - totalDamage).toDouble() / ad).toLong()))
    }
    println(damageList.map { it.second }.sum())
}