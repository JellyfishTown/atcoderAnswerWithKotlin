package past.point400

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val aList = readLine()!!.split(' ').map(String::toInt)

    val nums = mutableMapOf(1 to 2, 2 to 5, 3 to 5, 4 to 4, 5 to 5, 6 to 6, 7 to 3, 8 to 7, 9 to 6)
    for (i in 1..9) if (aList.contains(i).not()) nums.remove(i)//利用可能な数字のみをnumsに残す
    val bars = mutableMapOf<Int, Int>()//(必要な本数,数値)のマップ
    nums.forEach { entry -> bars[entry.value] = entry.key }//同じ本数が必要な数値の内、小さいほうを除去


    //配るDPで最大桁数を算出
    val dp = Array(n + 10) { 0 }//dp[i]=マッチ棒がちょうどi本の時に作れる最大桁数
    for (bar in bars.keys) dp[bar] = 1
    for (bar in bars.keys) {
        for (i in 1 until n) {
            if (dp[i] != 0) dp[i + bar] = Math.max(dp[i + bar], dp[i] + 1)
        }
    }

    var ans = ""
    //一番右の1桁以外に何が入りうるかを算出する
    var leftBar = n//残りのマッチ棒本数
    for (i in 1 until dp[n]) {
        for (num in bars.values.sortedDescending()) {
            val bar = bars.filterValues { it == num }.keys.toList().first()
            if (leftBar - bar >= 0 && dp[leftBar - bar] == dp[leftBar] - 1) {
                ans += num.toString()
                leftBar -= bar
                break
            }
        }
    }

    ans += bars[leftBar]!!.toString()
    println(ans)
}
