package participated.abc109

import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val board = Array(h + 2) { Array(w + 2) {0} }
    for (i in 1..h) {
        val input = readLine()!!.split(' ').map(String::toInt).toMutableList()
        input.add(0,0)
        input.add(0)
        board[i] = input.toTypedArray()
    }

    var sousaNum = 0
    val sousaList = mutableListOf<List<Int>>()
    for (i in 1..h) {
        for (j in 1..w) {
            if (board[i][j] % 2 == 1) {
                if (j != w) {
                    board[i][j] = board[i][j] - 1
                    board[i][j + 1] = board[i][j + 1] + 1
                    sousaList.add(Arrays.asList(i, j, i, j + 1))
                    sousaNum++
                } else if (i != h) {
                    board[i][j] = board[i][j] - 1
                    board[i + 1][j] = board[i + 1][j] + 1
                    sousaList.add(Arrays.asList(i, j, i + 1, j))
                    sousaNum++
                }
            }
        }
    }

    println(sousaNum)
    sousaList.forEach{println(it.joinToString(" "))}
}
