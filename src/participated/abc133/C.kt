package participated.abc133

fun main(args: Array<String>) {
    val (l, r) = readLine()!!.split(' ').map(String::toLong)
    if (r - l >= 2019) {
        println(0)
        return
    }
    var min = Long.MAX_VALUE
    for (i in l until r) {
        for (j in (l + 1)..r) {
            min = Math.min(min, ((i) * (j) % 2019))
        }
    }
    println(min)
}
