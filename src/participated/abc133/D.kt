package participated.abc133

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val sum = aList.sum()
    val ansList = Array(n) { 0L }

    var x1 = 0L
    for (i in 0 until n) {
        x1 += if (i % 2 == 0) aList[i] else -aList[i]
    }
    ansList[0]= x1
    for(i in 0 until n-1){
        ansList[i+1] = (aList[i] - ansList[i]/2)*2
    }
    println(ansList.joinToString(" "))
}
