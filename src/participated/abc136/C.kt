package participated.abc136

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hList = readLine()!!.split(' ').map(String::toLong).reversed().toMutableList()

    for (i in 0 until n - 1) {
        if (hList[i] + 1 < hList[i + 1]) {
            println("No")
            return
        } else if (hList[i] < hList[i + 1]) {
            hList[i + 1] = hList[i + 1] - 1
        }
    }
    println("Yes")
}


//var count1 = 0
//var count2 = 0
//
//(0 until n - 1).forEach {
//    if (hList[it] > hList[it + 1]) count1++
//    if (hList[it] > hList[it + 1] + 1) count2++
//
//}
//if (count1 >= 2 || count2 >= 1) {
//    println("No")
//
//} else {
//    println("Yes")
//}
