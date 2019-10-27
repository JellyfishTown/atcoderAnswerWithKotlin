package participated.abc143

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val lList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    val lIndex = Array(lList[0].toInt() + 1) { 0 }
    for (i in 0 until n) {
        val l = lList[i]
        for(j in 0..l){
            lIndex[j.toInt()] = i
        }
    }
    var count = 0L
    for (first in 0..(n - 3)) {
        for (second in (first + 1)..(n - 2)) {
            val thirdMinLength = lList[first] - lList[second] + 1
            val p = Math.max(0,lIndex[thirdMinLength.toInt()] - second)
            count += p
        }
    }
    println(count)
}