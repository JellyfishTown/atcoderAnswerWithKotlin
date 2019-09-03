package participated.ext011

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val map = Array(n) { Array(n + 1) { 0 } }

    if (n == 2) {
        println(1)
        return
    }

    var level = 2
    for (diff in 1 until (n - 1)) {
        for (start in 1 until (n - 1)) {
            var cur = start
            var count = 0
            while (true) {
                count++
                val next = ((cur + diff - 1) % n) + 1
                if (count >= 4) {
                    val i = (cur - diff * 3 + n * 3 - 1) % n + 1
                    if (map[Math.min(i, cur)][Math.max(i, cur)] == 0) map[Math.min(i, cur)][Math.max(i, cur)] = level
                }
                if (cur + diff > n) {
                    if (count % 2 == 0) {
                        if (map[next][cur] == 0) map[next][cur] = level
                        else break
                    } else {
                        if (map[next][cur] == 0) map[next][cur] = 1
                        else break
                    }
                } else {
                    if (count >= 4) {
                        val i = (cur - diff * 3 + n * 3 - 1) % n + 1
                        if (map[Math.min(i, cur)][Math.max(i, cur)] == 0) map[Math.min(i, cur)][Math.max(i, cur)] = level
                    }
                    if (map[cur][next] == 0) map[cur][next] = level
                    else break
                }
                cur = next
            }
        }
        level++
    }

    for (i in 1 until n) {
        for (j in i + 1..n) {
            print("${map[i][j]} ")
        }
        println()
    }
}