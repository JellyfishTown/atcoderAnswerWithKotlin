package point200

//fun point300.point300.point300.point200.point400.point200.point200.point200.point400.abc106.abc104.main(args: Array<String>) {
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


