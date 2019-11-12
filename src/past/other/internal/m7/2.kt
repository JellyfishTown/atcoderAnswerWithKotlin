package past.other.internal.m7

fun main(args: Array<String>) {
    val (n, m, r, c) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(n + 2) { Array(m + 2) { '.' } }

    for (i in 1..n) {
        map[i][1] = '#'
        map[i][c] = '#'
        map[i][m] = '#'
    }
    for (i in 1..m) {
        map[1][i] = '#'
        map[r][i] = '#'
        map[n][i] = '#'
    }
    for (i in 1..n) {
        for (j in 1..m) {
            print(map[i][j])
        }
        println()
    }
}

