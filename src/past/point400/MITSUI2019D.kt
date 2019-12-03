package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var ans = 0
    for (i in 0..999) {
        var index = 0
        val num = ("00$i").takeLast(3)
        for (c in s) {
            if (c == num[index]) {
                index++
                if (index == 3) {
                    ans++
                    break
                }
            }
        }
    }
    println(ans)
}
