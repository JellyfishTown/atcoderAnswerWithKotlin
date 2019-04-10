package past.point400

fun main(args: Array<String>) {
    val s = readLine()!!
    var ans = s.length.toLong() * (s.length - 1)//全ての階に1回で行ける場合のコスト
    for ((i, c) in s.withIndex())
        ans += if (c == 'U') i else (s.length - i - 1)//乗り換えが必要な場合をコストに追加
    println(ans)
}
