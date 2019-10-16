package participated.agc038

fun main(args: Array<String>) {
    val (h, w, a, b) = readLine()!!.split(' ').map(String::toLong)
    if ((w == 1L && a != 0L) || (h == 1L && b != 0L)) {
        println("No")
        return
    }
    for (r in 1..h) {
        var line = ""
        for (c in 1..w) {
            line += if (r <= b && c <= a) 1
            else if (r <= b) 0
            else if (c <= a) 0
            else 1
        }
        println(line)
    }
}
