package point300

fun main(args: Array<String>) {
    var (x, y) = readLine()!!.split(' ').map(String::toLong)
    var count = 0
    while (x <= y) {
        count++
        x *= 2
    }
    println(count)
}

