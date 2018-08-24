fun main(args: Array<String>) {
    var (d, n) = readLine()!!.split(" ").map(String::toInt)
    if (n == 100) n++
    if (d == 0) {
        println(n)
    } else if (d == 1) {
        println(n * 100)
    } else {
        println(n * 10000)
    }
}

