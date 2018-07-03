
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map(String::toInt)
    var sum = 0
    var sum2 = 0
    var ave = a.average().toInt()
    for (i in 0 until n) {
        sum += Math.pow((a[i] - ave).toDouble(), 2.0).toInt()
        sum2 += Math.pow((a[i] - ave - 1).toDouble(), 2.0).toInt()
    }
    println(Math.min(sum,sum2))
}

