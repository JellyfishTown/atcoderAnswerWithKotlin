package participated.abc108

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    var num = 0.5
    var num2 = 0L
    if (k / 2 > n) {
        println(0)
    } else if (k % 2L == 0L) {
        while (true) {
            num += 1.0
            if (n < num * k) {
                num -= 1.0
                break
            }
        }
        while (true) {
            num2 += 1L
            if (n < num2 * k) {
                num2 -= 1L
                break
            }
        }
        val ceil = Math.ceil(num).toLong()
        println((ceil * ceil * ceil) + (num2 * num2 * num2))
    } else {
        println((n / k) * (n / k) * (n / k))
    }
}
