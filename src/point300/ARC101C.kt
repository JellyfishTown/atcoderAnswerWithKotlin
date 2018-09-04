package point300

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val x = readLine()!!.split(' ').map(String::toLong)
    println((0..(x.size - k)).map{x[it + k - 1] - x[it] + Math.min(Math.abs(x[it + k - 1]), Math.abs(x[it]))}.min())
}

