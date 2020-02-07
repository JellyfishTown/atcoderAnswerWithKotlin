package past.other.past

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    println(input[2])
}
