package point200

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toLong)
    if (a == 0L || b == 0L) {
        println("Zero")
        return
    }
    if (a <= 0 && b <= 0) {
        if ((b - a) % 2 == 0L) {
            println("Negative")
        } else {
            println("Positive")
        }
    } else if (a <= 0 && 0 <= b) {
        println("Zero")
    } else if (0 <= a && 0 <= b) {
        println("Positive")
    }
}

