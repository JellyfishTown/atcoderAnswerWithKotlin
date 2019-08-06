package past.point400

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val tdList = (1..n).map { readLine()!!.split(' ').map(String::toLong).let { Pair(it[0], it[1]) } }.sortedByDescending { it.second }

    val selected = tdList.take(k).sortedByDescending { it.second }//美味しさだけで選ばれたk個の寿司
    val notSelected = tdList.takeLast(n - k).sortedByDescending { it.second }//選ばれなかった寿司
    val ds = selected.map { it.first }.toSet()//選択されたネタの一覧
    //選ばれた寿司の中で、ネタが重複しているもののうち、スコアが低い方のリストを作成する
    val changeableSelected = mutableListOf<Pair<Long, Long>>()
    run {
        val tempD = mutableSetOf<Long>()
        for (s in selected) {
            if (tempD.contains(s.first)) {
                changeableSelected.add(s)
            } else {
                tempD.add(s.first)
            }
        }
    }

    //選ばれなかった寿司の中で、選んだすしに含まれないもののうち、スコアが高い方のリストを作成する
    val changeableNotSelected = mutableListOf<Pair<Long, Long>>()
    run {
        val tempD = mutableSetOf<Long>()
        for (ns in notSelected) {
            if (tempD.contains(ns.first).not() && ds.contains(ns.first).not()) {
                changeableNotSelected.add(ns)
                tempD.add(ns.first)
            }
        }
    }

    //選んだ寿司の中でネタが重複しているもののうち、スコアが小さいものから1つ消し、選ばなかったものから1つ追加する、という処理を実行できなくなるまで繰り返し、その中で最大の満足度を探す
    var dc = ds.count().toLong()//ネタの種類数
    var maxScore = selected.map { it.second }.sum() + dc * dc//暫定最大満足ポイント
    var tempMax = maxScore
    while (changeableSelected.size > 0 && changeableNotSelected.size > 0) {
        tempMax = tempMax - changeableSelected.last().second + changeableNotSelected.first().second - dc * dc + (dc + 1) * (dc + 1)
        dc++
        changeableSelected.removeAt(changeableSelected.size - 1)
        changeableNotSelected.removeAt(0)
        maxScore = Math.max(maxScore, tempMax)
    }
    println(maxScore)
}
