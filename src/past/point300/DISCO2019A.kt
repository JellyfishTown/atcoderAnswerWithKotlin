fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()
    var ans = 0.0
    var con = 0
    var max = 0
    for (i in 0 until n) {
        if (s[i] == '-') {
            ans += 1
            con = 0
        } else {
            ans += 1.0 / (con.toDouble() + 2.0)
            con++
            max = Math.max(max, con)
        }
    }
    println(ans - 1 + 1.0 / (max + 2.0))
}
