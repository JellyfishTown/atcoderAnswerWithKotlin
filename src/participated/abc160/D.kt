package participated.abc160

fun main(args: Array<String>) {
    val (n, x, y) = readLine()!!.split(' ').map(String::toInt)
    val ansMap = Array(n + 1) { IntArray(n + 1) { 0 } }
    for (i in 1..n) {
        for (j in 1..n) {
            ansMap[i][j] = Math.abs(i - j)
        }
    }
    ansMap[x][y] = 1
    ansMap[y][x] = 1
    for (i in 1..n) {
        for (j in 1..n) {
            ansMap[i][j] = Math.min(ansMap[i][j], ansMap[i][x] + ansMap[y][j] + 1)
            ansMap[i][j] = Math.min(ansMap[i][j], ansMap[i][y] + ansMap[x][j] + 1)
        }
    }
    val ansArray = IntArray(n) { 0 }
    for (i in 1..n) {
        for (j in 1..n) {
            ansArray[ansMap[i][j]]++
        }
    }
    for (k in 1 until n) {
        println(ansArray[k] / 2)
    }
}
