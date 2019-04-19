package past.point400

//https://atcoder.jp/contests/tenka1-2018/tasks/tenka1_2018_d
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val yesN = IntArray(1000) { (it * (it + 1)) / 2 }//条件を満たすnの一覧
    val groupSize = yesN.indexOf(n)
    if (groupSize > 0) {
        println("Yes")
        val groupNum = groupSize + 1
        println(groupNum)

        //答えを示す配列を生成する
        val ans = Array(groupNum) { Array(groupSize) { 0 } }
        var num = 1
        var lastGroupIndex = 0
        for (i in 0 until groupSize) {
            for (j in 0 until groupSize) {
                if (j == groupSize - i) {
                    for (k in 0..i) {
                        ans[i][j + k - 1] = ans[i - k][j - 1]
                    }
                    break
                }
                ans[i][j] = num++
            }
            ans[groupNum - 1][lastGroupIndex++] = num - 1
        }

        ans.forEach { println("$groupSize " + it.joinToString(" ")) }
    } else {
        println("No")
    }
}
