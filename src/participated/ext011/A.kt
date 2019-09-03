package participated.ext011

fun main(args: Array<String>) {
    val (m, d) = readLine()!!.split(' ').map(String::toLong)

    var count = 0
    for (mt in 1..m) {
        for (dt in 1..d) {
            if ((dt % 10) < 2) continue
            if ((dt / 10) < 2) continue
            if ((dt / 10) * (dt % 10) == mt) count++
        }
    }
    println(count)
}
