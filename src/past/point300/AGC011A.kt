fun main(args: Array<String>) {
    val (n, c, k) = readLine()!!.split(' ').map(String::toLong)
    val tList = mutableListOf<Long>()
    for (i in 0 until n) tList.add(readLine()!!.toLong())
    tList.sort()
    var countBus = 1L
    var countMan = 1L
    var first = tList[0]
    for (i in 1 until n) {
        val t = tList[i.toInt()]
        if (countMan < c && t <= first + k) {
            countMan++
        }else{
            countMan = 1L
            first = t
            countBus++
        }
    }
    println(countBus)
}

