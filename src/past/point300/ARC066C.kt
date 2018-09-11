package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).sorted()
    val mod = n % 2
    for ((i, a) in aList.withIndex()) {
        if ((a != i && (a - 1) != i) || a % 2 == mod) {
            println(0)
            return
        }
    }
    var answer = 1L
    for (i in 1..(n / 2)) {
        answer = (answer * 2L) % 1000000007
    }
    println(answer)
}
