package past.point400

//https://atcoder.jp/contests/chokudai_S002/tasks/chokudai_S002_i
fun main(args: Array<String>) {
    fun winLeft(left: Pair<Int, Int>, right: Pair<Int, Int>): Boolean {
        val leftDieCount = (left.first + right.second - 1) / right.second
        val rightDieCount = (right.first + left.second - 1) / left.second
        return leftDieCount > rightDieCount
    }
    val n = readLine()!!.toInt()
    val abList = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        abList.add(Pair(a, b))
    }
    var winner = abList[0]
    var winnerI = 0
    for (i in 1 until n) {
        val challenger = abList[i]
        if (winLeft(winner, challenger)) {
            // do nothing
        } else {
            winner = challenger
            winnerI = i
        }
    }
    val winAll = (0 until n).all { it == winnerI || winLeft(winner, abList[it]) }
    println(if (winAll) winnerI + 1 else -1)
}
