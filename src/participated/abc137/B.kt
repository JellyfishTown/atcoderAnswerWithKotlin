package participated.abc137

fun main(args: Array<String>) {
    val (k, x) = readLine()!!.split(' ').map(String::toLong)
    println(
            ((x - k + 1)..(x + k - 1)).filter {
                (it >= -1000000 && it <= 1000000)
            }.joinToString(" ")
    )
}
