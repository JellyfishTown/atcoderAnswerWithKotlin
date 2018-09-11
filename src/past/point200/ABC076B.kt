package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()

    var ans = 1
    for (i in 1..n) {
        if (ans > k) {
            ans += k
        } else {
            ans *= 2
        }
    }
    println(ans)

}
