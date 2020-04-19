package participated.abc162

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var sum = 0L
    for (i in 1..n) {
        if (i % 3 != 0 && i % 5 != 0) sum += i
    }
    println(sum)
}
