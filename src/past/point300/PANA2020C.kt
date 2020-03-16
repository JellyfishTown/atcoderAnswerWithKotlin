package past.point300

import java.math.BigDecimal
import java.math.MathContext

fun main(args: Array<String>) {
    fun sqrt(a: BigDecimal, scale: Int = 50): BigDecimal {
        var x = BigDecimal(
                Math.sqrt(a.toDouble()), MathContext.DECIMAL64)
        if (scale < 17) return x
        val b2 = BigDecimal(2)
        var tempScale = 16
        while (tempScale < scale) {
            x = x.subtract(
                    x.multiply(x).subtract(a).divide(
                            x.multiply(b2), scale, BigDecimal.ROUND_HALF_EVEN))
            tempScale *= 2
        }
        return x
    }
    val (a, b, c) = readLine()!!.split(' ').map(String::toDouble)
    val ba = BigDecimal(a)
    val bb = BigDecimal(b)
    val bc = BigDecimal(c)
    println(if (sqrt(ba).plus(sqrt(bb)) < sqrt(bc)) "Yes" else "No")
}


