fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val aList = readLine()!!.split(' ').map(String::toLong).sortedDescending()
    println(aList.filterIndexed { index, l -> (index % 2 == 1) && (index <= 2 * n) }.sum())
}

