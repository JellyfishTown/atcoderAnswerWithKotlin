package point300

//参考資料
//https://qiita.com/drken/items/ace3142967c4f01d42e9
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val memo = Array(200000, { n })
    memo[0] = 0

    for (i in 0 until n) {
        var pow6 = 1
        while (pow6 + i <= n) {
            memo[i + pow6] = Math.min(memo[i + pow6], memo[i] + 1)
            pow6 *= 6
        }

        var pow9 = 1
        while (pow9 + i <= n) {
            memo[i + pow9] = Math.min(memo[i + pow9], memo[i] + 1)
            pow9 *= 9
        }
    }
    println(memo[n])
}

