import java.util.*

fun main(args: Array<String>) {
    //input
    val (n, m, b) = readLine()!!.split(" ").map(String::toInt)
    val (gy, gx) = readLine()!!.split(" ").map { it.toInt() + 1 }
    val rcList = (1..m).map {
        val (rys, rxs, cs) = readLine()!!.split(" ")
        Triple(rys.toInt() + 1, rxs.toInt() + 1, rys)
    }
    val bList = (1..b).map {
        val (by, bx) = readLine()!!.split(" ").map { it.toInt() + 1 }
        Pair(by, bx)
    }

    //extends map
    val map = Array(3 * n + 1) { Array(3 * n + 1) { "X" } }
    val robotMap = Array(3 * n + 1) { Array(3 * n + 1) { "X" } }

    //set default to map
    fun paintMap(tempMap: Array<Array<String>>, y: Int, x: Int, c: String) {
        for (h in 0..2) for (w in 0..2) tempMap[(h * n) + ((y - 1) % n + 1)][(w * n) + ((x - 1) % n + 1)] = c
    }
    bList.forEach {
        paintMap(map, it.first, it.second, "B")
    }
    rcList.forEach {
        paintMap(robotMap, it.first, it.second, it.third)
    }
    paintMap(map, gy, gx, "G")


    //set signs around goal
    val dc = arrayOf("R", "D", "L", "U")
    val dcReverse = arrayOf("L", "U", "R", "D")
    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)
    val queue = ArrayDeque<Triple<Int, Int, String>>()
    for (i in 0..3) {
        val y = n + gy + dy[i]
        val x = n + gx + dx[i]
        if (((y in 1..n * 3) && (x in 1..n * 3)).not()) continue
        queue.addLast(Triple(y, x, dcReverse[i]))
    }

    //set signs by dfs
    while (queue.isNotEmpty()) {
        val (y, x, c) = queue.removeLast()
        if (((y in 1..n * 3) && (x in 1..n * 3)).not()) continue
        if (map[y][x] == "X") {
            paintMap(map, y, x, c)
            for (i in 0..3) {
                if (c == dc[i] || c == dcReverse[i]) continue
                val ny = y + dy[i]
                val nx = x + dx[i]
                queue.addLast(Triple(ny, nx, dcReverse[i]))
            }
            for (i in 0..3) {
                if (c != dcReverse[i]) continue
                val ny = y + dy[i]
                val nx = x + dx[i]
                queue.addLast(Triple(ny, nx, dcReverse[i]))
            }
        }
    }

    //remove unused signs
    for (w in 41..80) {
        for (h in 41..80) {
            if (map[h][w] == "U" && (map[h + 1][w] == "U" || map[h + 1][w] == "X") && (map[h - 1][w] == "U" || map[h - 1][w] == "X") && map[h][w - 1] != "R" && map[h][w + 1] != "L") {
//                if (robotMap[h][w] == "X" || robotMap[h][w] == "U") {
                    paintMap(map, h, w, "X")
//                }
            }
        }
    }
    for (w in 41..80) {
        for (h in 41..80) {
            if (map[h][w] == "D" && (map[h + 1][w] == "D" || map[h + 1][w] == "X") && (map[h - 1][w] == "D" || map[h - 1][w] == "X") && map[h][w - 1] != "R" && map[h][w + 1] != "L") {
//                if (robotMap[h][w] == "X" || robotMap[h][w] == "D") {
                    paintMap(map, h, w, "X")
//                }
            }
        }
    }
    for (w in 41..80) {
        for (h in 41..80) {
            if (map[h][w] == "R" && (map[h][w - 1] == "R" || map[h][w - 1] == "X") && (map[h][w + 1] == "R" || map[h][w + 1] == "X") && map[h - 1][w] != "D" && map[h + 1][w] != "U") {
//                if (robotMap[h][w] == "X" || robotMap[h][w] == "R") {
                    paintMap(map, h, w, "X")
//                }
            }
        }
    }
    for (w in 41..80) {
        for (h in 41..80) {
            if (map[h][w] == "L" && (map[h][w - 1] == "L" || map[h][w - 1] == "X") && (map[h][w + 1] == "L" || map[h][w + 1] == "X") && map[h - 1][w] != "D" && map[h + 1][w] != "U") {
//                if (robotMap[h][w] == "X" || robotMap[h][w] == "L") {
                    paintMap(map, h, w, "X")
//                }
            }
        }
    }

    //collect signs
    val signs = mutableListOf<Triple<Int, Int, String>>()
    for (i in 1..n) {
        for (j in 1..n) {
            if (map[i][j] in dc) signs.add(Triple(i, j, map[i][j]))
        }
    }

    //output answer
    println(signs.size)
    signs.forEach {
        println("${it.first - 1} ${it.second - 1} ${it.third}")
    }
}