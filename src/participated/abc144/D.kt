package participated.abc144

fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(' ').map(String::toDouble)
    val degree =
            if (a * a * b <= x * 2) {
                val k = 2 * (a * b - x / a) / a
                val rad = Math.atan(k / a)
                Math.toDegrees(rad)
            } else {
                val k = a * x / (a * a * b / 2)
                val rad = Math.atan(k / b)
                90.0 - Math.toDegrees(rad)
            }
    println(degree)
}
