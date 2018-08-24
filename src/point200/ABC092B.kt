package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val (d, x) = readLine()!!.split(" ").map(String::toInt)
    val a = mutableListOf(0)
    for (i in 1..n) {
        a.add(readLine()!!.toInt())
    }
    var accum = x
    for (i in 1..n) {
        accum += if (a[i] == 1) {
            d
        } else {
            (d - 1) / a[i] + 1
        }
    }
    println(accum)
}