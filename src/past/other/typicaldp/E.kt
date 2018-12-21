package past.other.typicaldp

//未完成
fun main(args: Array<String>) {
    val mod = 1000000007L
    val d = readLine()!!.toInt()
    val n = readLine()!!.toCharArray().reversed()
    //j桁目まで見たときの、あまりがiになるパターン数
    val dp = Array(d) { LongArray(n.size + 1) { 0L } }
    val dp2 = Array(d) { LongArray(n.size + 1) { 0L } }

    dp[0][0] = 1
    dp2[0][0] = 1

    for (nod in 1..(n.size - 1)) {//number of digits
        for (rest in 0..(d - 1)) {
            for (num in 0..9) {
                dp[(rest + num) % d][nod] += dp[rest][nod - 1] % mod
            }
        }
    }
    for (nod in 1..n.size) {//number of digits
        val currentN = n[nod - 1].toString().toInt()
        for (rest in 0..(d - 1)) {
            for (num in 0..9) {
                when {
                    currentN > num ->
                        dp2[(rest + num) % d][nod] += dp[rest][nod - 1] % mod
                    currentN < num -> {
                    }
                    currentN == num -> dp2[(rest + num) % d][nod] += dp2[rest][nod - 1] % mod

                }
            }
        }
    }
    println(dp2[0][n.size] - 1)
}