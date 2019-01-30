//#2584318を参考にコード記述
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toLong)
    var r = 0
    var sum = 0L
    var ans = 0L
    for (l in 0..(n - 1)) {
        while (r < n && (sum + aList[r]) == (sum xor aList[r])) {
            sum += aList[r]
            r++
        }
        ans += r - l
        sum -= aList[l]
        if (l > r) r = l
    }
    println(ans)
}
