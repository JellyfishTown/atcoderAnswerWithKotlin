package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt)
    val a2 = aList.filter { it % 2 == 0 && it % 4 != 0 }.count()
    val a4 = aList.filter { it % 4 == 0 }.count()
    println(
            if (n / 2 <= a4) "Yes"
            else if (a2 == n) "Yes"
            else if (n - (a4 * 2) <= a2) "Yes"
            else "No"
    )
}
