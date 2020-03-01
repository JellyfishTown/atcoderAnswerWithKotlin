package participated.abc155

fun main(args: Array<String>) {
    val s = readLine()!!.reversed()
    var ans = 0L
    var pool = 0
    for (c in s) {
        val num = c.toString().toInt()

        when {
            (num == 0) -> {
                ans += pool
                pool = 0
            }
            (num in 1..4) -> {
                ans += pool
                pool = 0
                ans += num
            }
            (num == 5) -> {
                ans += num
            }
            (num in 6..9) -> {
                ans -= pool
                ans += 10 - num
                pool = 1
            }
        }
    }
    println(ans+pool)
}
