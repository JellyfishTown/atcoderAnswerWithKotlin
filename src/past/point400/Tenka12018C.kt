package past.point400

//https://atcoder.jp/contests/tenka1-2018/tasks/tenka1_2018_c
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = Array(n) { readLine()!!.toLong() }.sorted()
    val mins = a.take(n / 2)
    val maxs = a.takeLast(n / 2)
    println((maxs.sum() - mins.sum()) * 2 +
            if (n % 2 == 1) Math.max(mins.last() - a[n / 2], a[n / 2] - maxs.first())
            else mins.last() - maxs.first()
    )
}
