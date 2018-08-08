package point300

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val pointList = Array(200010, { 0 })
    for (i in 0 until m) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        if (a == 1) {
            pointList[b]++
        } else if (b == n) {
            pointList[a]++
        }

    }
    if (pointList.any { it >= 2 }) {
        println("POSSIBLE")
    } else {
        println("IMPOSSIBLE")
    }
}
