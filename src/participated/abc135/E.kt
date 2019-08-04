package participated.abc135

fun main(args: Array<String>) {
    val k = readLine()!!.toLong()
    var (x, y) = readLine()!!.split(' ').map(String::toLong)

    val gd = Math.abs(x) + Math.abs(y)
    if (k % 2 == 0L && gd % 2 != 0L) {
        println(-1)
        return
    }
    val dx = if (x < 0) -1L else 1L
    val dy = if (y < 0) -1L else 1L
    x = Math.abs(x)
    y = Math.abs(y)

    val c = (k - (gd % k)) % k

    if (gd < k && c % 2 != 1L) {
        val n = 3
        println(n)

        var (tx, ty) = Pair(0L, 0L)
        val midy = -(k - x) * dy
        val midx = (x + (k + x - y) / 2) * dx
        var phase = if (midy == 0L) 2 else 1
        var tk = k
        while (true) {
            when (phase) {
                1 -> {
                    ty -= dy
                    if (ty == midy) phase = 2
                }
                2 -> {
                    tx += dx
                    if (tx == midx) phase = 3
                }
                3 -> {
                    ty += dy
                    if (ty == y) phase = 4
                }
                4 -> {
                    tx -= dx
                    if (tx == x) phase = 5
                }
            }
            tk--
            if (tk == 0L) {
                println("$tx $ty")
                tk = k
            }
            if (phase == 5) break
        }
    } else {
        val n = if (gd < k) 2
        else if (gd >= k && c % 2 == 0L) Math.ceil((x + y).toDouble() / k.toDouble()).toInt()
        else Math.ceil((x + y).toDouble() / k.toDouble()).toInt() + 1

        println(n)

        var (tx, ty) = Pair(0L, 0L)
        val midy = -(k * n - x - y) / 2 * dy
        var phase = if (midy == 0L) 2 else 1
        var tk = k
        while (true) {
            when (phase) {
                1 -> {
                    ty += -dy
                    if (ty == midy) phase = 2
                }
                2 -> {
                    tx += dx
                    if (tx == x) phase = 3
                }
                3 -> {
                    ty += dy
                    if (ty == y) phase = 4
                }
            }
            tk--
            if (tk == 0L) {
                println("$tx $ty")
                tk = k
            }
            if (phase == 4) break
        }
    }
}
