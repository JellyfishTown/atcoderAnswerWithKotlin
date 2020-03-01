package participated.abc156

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xList = readLine()!!.split(' ').map(String::toInt).sorted()
    var min = Int.MAX_VALUE
    for (i in 1..100) {
        min = Math.min(min, xList.map { (it - i) * (it - i) }.sum())
    }
    println(min)
}
