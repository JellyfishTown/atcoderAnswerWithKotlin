package past.other.internal.m3

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val inputList = mutableListOf<Map<Int, Double>>()
    val xSet = mutableSetOf<Int>()//存在するxのパターン網羅

    (1..n).forEach {
        //箱ごとの入力値の受け取り
        val input = readLine()!!.split(' ').map(String::toInt)
        val m = input[0]
        val xList = input.takeLast(m)

        //1つの箱の中のxの割合のみが重要であり、それぞれの個数は関係ないのでxの割合に変換して変数mapに格納
        val map = mutableMapOf<Int, Double>()//<x,その箱の中におけるxの割合>
        xList.toSet().forEach { s ->
            map[s] = xList.count { l -> l == s }.toDouble() / m.toDouble()
        }
        inputList.add(map)

        xSet.addAll(xList)//存在するxのパターン網羅
    }

    val ans = mutableListOf<MutableMap<Int, Double>>()//ans[i][x] = d  i個目の箱からボールを取り出した時点でxの出ている期待値はd
    ans.add(mutableMapOf())
    xSet.forEach { ans[0][it] = 0.0 }//1個も箱から取り出していないので全てのxについて期待値は0
    for (i in 1..n) {
        val input = inputList[i-1]//i個目の箱のxの割合を取得
        ans.add(mutableMapOf())

        for (x in xSet) {
            //i個目の箱まででxの出ている確率は、(i-1個目の箱まででxが出ている確率)+((i-1個目の箱まででxが出ていない確率)*(i個めの箱からxが出る確率))
            ans[i][x] = ans[i-1][x]!! + (1 - ans[i-1][x]!!) * (input[x]?:0.0)
        }
    }

    //入力例1の場合だと、最終的に1が0.33、2が0.67、3が0.33、4が0.5の確率で出ている
    //これらの数値を単純に足し合わせると種類数の期待値となる
    println(ans.last().values.sum())
}
