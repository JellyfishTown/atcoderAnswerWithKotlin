package point200

fun main(args: Array<String>) {
    val (x, y, z) = readLine()!!.split(" ").map(String::toInt)
    var count = 1
    while (true) {
        if (x < ((y + z) * count + z)) {
            println(count - 1)
            return
        } else {
            count++
        }
    }
}
