package past.point200

//fun past.point300.past.point300.past.point300.past.point200.past.point400.past.point200.past.point200.past.point200.past.point400.participated.abc106.participated.abc104.participated.past.point100.main(args: Array<String>) {
//    val (a, b) = readLine()!!.split(" ").map(String::toInt)
//    println(if (a * b % 2 == 0) "Even" else "Odd")
//}
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map(String::toInt)
    println((an.map { countTwoNum(it) }).min())
}

fun countTwoNum(num: Int): Int {
    var twoNum = 0
    var temp = num
    while (temp % 2 == 0) {
        twoNum++
        temp /= 2
    }
    return twoNum
}


