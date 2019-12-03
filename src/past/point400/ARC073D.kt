package past.point400

fun main(args: Array<String>) {
    val (n, totalW) = readLine()!!.split(' ').map(String::toLong)
    val things = Array(4) { mutableListOf<Long>() }
    var w1 = -1L
    (1..n).forEach {
        val (w, v) = readLine()!!.split(' ').map(String::toLong)
        if (w1 == -1L) w1 = w
        things[(w - w1).toInt() % 4].add(v)
    }
    (0..3).forEach { things[it].sortDescending() }

    var ans = 0L
    for (i0 in 0..things[0].size) {
        for (i1 in 0..things[1].size) {
            for (i2 in 0..things[2].size) {
                for (i3 in 0..things[3].size) {
                    val curW = i0 * w1 + i1 * (w1 + 1) + i2 * (w1 + 2) + i3 * (w1 + 3)
                    if (curW > totalW) break
                    else ans = Math.max(ans,
                            things[0].take(i0).sum()
                                    + things[1].take(i1).sum()
                                    + things[2].take(i2).sum()
                                    + things[3].take(i3).sum()
                    )
                }
            }
        }
    }
    println(ans)
}
