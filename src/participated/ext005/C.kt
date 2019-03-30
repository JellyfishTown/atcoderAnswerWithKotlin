package participated.ext005

//https://yahoo-procon2019-qual.contest.atcoder.jp/assignments
fun main(args: Array<String>) {
    val (k, a, b) = readLine()!!.split(' ').map(String::toLong)
    if ((b - a).toDouble() / 2 > 1.0) {
        var num = 1L
        var i = 1L
        while (i <= k) {
            if (i == k) {
                num++
            } else {
                if (num < a) {
                    num++
                } else {
                    num = num - a + b
                    i++
                }
            }
            i++
        }
        println(num)
    } else {
        println(k + 1)
    }
}
