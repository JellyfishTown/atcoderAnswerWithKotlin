fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ")
            .mapIndexed { index, it -> it.toInt() - (index + 1) }.sorted()
    println(aList.map {  Math.abs(it - aList[n / 2]) }.sum())
}


