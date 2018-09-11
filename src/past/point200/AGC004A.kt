package past.point200

fun main(args: Array<String>) {
    var input = readLine()!!.split(" ").map(String::toLong)
    if (input[0] % 2 == 0L || input[1] % 2 == 0L || input[2] % 2 == 0L) {
        println(0)
        return
    }
    input = input.sorted()
    println(input[0] * input[1])
}

