package participated.abc130

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toLong)
    val aList = readLine()!!.split(' ').map(String::toLong)
    var l = 0
    var r = 0
    var count = 0L
    var sum = aList[0]
    while (true) {
        if (sum >= k) {
            count += n - r
            sum -= aList[l]
            l++
            if (l == n.toInt()) break
        } else {
            r++
            if (r == n.toInt()) break
            sum += aList[r]
        }
    }
    println(count)
}
