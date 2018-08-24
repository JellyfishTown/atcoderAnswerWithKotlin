fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var aList = readLine()!!.split(" ").map(String::toInt)
    var count = 0
    while (true) {
        aList = aList.filter { it % 2 == 0 }
        if (aList.isEmpty()) break
        count += aList.size
        aList = aList.map { it / 2 }
    }
    println(count)
}

