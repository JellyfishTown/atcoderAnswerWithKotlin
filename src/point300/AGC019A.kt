fun main(args: Array<String>) {
    val (q, h, s, d) = readLine()!!.split(" ").map(String::toLong)
    val n = readLine()!!.toLong()
    var qq = 4 * n
    var hq = 0L
    var sq = 0L
    var dq = 0L

    if (2 * q >= h && qq >= 2) {
        hq = qq / 2
        qq -= (qq / 2) * 2
    }

    if (2 * h >= s && hq >= 2) {
        sq = hq / 2
        hq -= (hq / 2) * 2
    }

    if (4 * q >= s && qq >= 4) {
        sq = qq / 4
        qq -= (qq / 4) * 4
    }

    if (2 * s >= d && sq >= 2) {
        dq = sq / 2
        sq -= (sq / 2) * 2
    }

    if (4 * h >= d && hq >= 4) {
        dq = hq / 4
        hq -= (hq / 4) * 4
    }

    if (8 * q >= d && qq >= 8) {
        dq = qq / 8
        qq -= (qq / 8) * 8
    }

    println(q * qq + h * hq + s * sq + d * dq)
}