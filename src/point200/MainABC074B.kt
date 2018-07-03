package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val x = readLine()!!.split(' ').map(String::toInt)
    var count = 0
    for (i in 0..(n - 1)) {
        count += 2 * Math.min(Math.abs(x[i]), Math.abs(k - x[i]))
    }
    println(count)
}