package participated.abc144

fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(' ').map(String::toDouble)
    if (a * a * b <= x * 2) {
        val k = 2 * (a * b - x / a) / a
        val atan = Math.atan(k / a)
        val degree = Math.toDegrees(atan)
        println(degree)
    } else {
        val baseDeg = Math.toDegrees(Math.atan(b / a))
        val half = a * a * b / 2
        val k = a * x / half
        val atan = Math.atan(k / b)
        val degree = 90.0 - Math.toDegrees(atan)
        println(degree)
    }
}