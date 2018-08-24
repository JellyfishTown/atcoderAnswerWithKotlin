fun main(args: Array<String>) {
    val (a, b, c, x, y) = readLine()!!.split(" ").map(String::toInt)
    if (a + b < c * 2) {
        println(a * x + b * y)
    } else {
        when {
            (x <= y) -> {
                if (b < c * 2) {
                    println(c * x * 2 + b * (y - x))
                } else {
                    println(c * y * 2)
                }
            }
            (x > y) -> {
                if (a < c * 2) {
                    println(c * y * 2 + a * (x - y))
                } else {
                    println(c * x * 2)
                }
            }
        }
    }
}
