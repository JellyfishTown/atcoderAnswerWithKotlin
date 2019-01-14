package participated.ext002

var sTemp = Array(0) { IntArray(0) { 0 } }
var sList = mutableListOf<MutableList<Char>>()

//https://aising2019.contest.atcoder.jp
//fun main(args: Array<String>) {
//    val (h, w) = readLine()!!.split(' ').map(String::toInt)
//    participated.ext003.sList.add(Array(w + 2) { 'X' }.toMutableList())
//    (1..h).forEach {
//        val element = readLine()!!.toCharArray().toMutableList()
//        element.add(0, 'X')
//        element.add(element.size, 'X')
//        participated.ext003.sList.add(element)
//    }
//    participated.ext003.sList.add(Array(w + 2) { 'X' }.toMutableList())
//
//    var sum = 0L
//    for (hi in 1..h) {
//        for (wi in 1..w) {
//            if (participated.ext003.sList[hi][wi] == '#') {
//                participated.ext003.sTemp = Array(h + 2) { IntArray(w + 2) { 0 } }
//                participated.ext003.temp(hi, wi, '#')
//                val sumBy = participated.ext003.sTemp.sumBy { it.sum() }
//                sum += sumBy
//            }
//        }
//    }
//    println(sum)
//}
//
//fun temp(curRow: Int, curCol: Int, curColor: Char) {
//    if (participated.ext003.sTemp[curRow][curCol] == 1) {
//        return
//    }
//
//    if (participated.ext003.sList[curRow][curCol] == '.') {
//        participated.ext003.sTemp[curRow][curCol] = 1
//    }
//
//    if (participated.ext003.sList[curRow - 1][curCol] != curColor && participated.ext003.sList[curRow - 1][curCol] != 'X') {
//        participated.ext003.temp(curRow - 1, curCol, if (curColor == '#') '.' else '#')
//    }
//    if (participated.ext003.sList[curRow][curCol - 1] != curColor && participated.ext003.sList[curRow][curCol - 1] != 'X') {
//        participated.ext003.temp(curRow, curCol - 1, if (curColor == '#') '.' else '#')
//    }
//    if (participated.ext003.sList[curRow + 1][curCol] != curColor && participated.ext003.sList[curRow + 1][curCol] != 'X') {
//        participated.ext003.temp(curRow + 1, curCol, if (curColor == '#') '.' else '#')
//    }
//    if (participated.ext003.sList[curRow][curCol + 1] != curColor && participated.ext003.sList[curRow][curCol + 1] != 'X') {
//        participated.ext003.temp(curRow, curCol + 1, if (curColor == '#') '.' else '#')
//    }
//}