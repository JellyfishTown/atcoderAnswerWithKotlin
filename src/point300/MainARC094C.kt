package point300

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toInt)
    val max3 = 3 * Math.max(a, Math.max(b, c))
    val sum = a + b + c
    if ((max3 % 2 == 1) && (sum % 2 == 0)
            || (max3 % 2 == 0) && (sum % 2 == 1)) {
        println((max3 + 3 - sum) / 2)
    } else {
        println((max3 - sum) / 2)
    }
}

