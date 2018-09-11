package past.point300

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val alist = readLine()!!.split(' ').map(String::toInt)

    var count = 0
    val lengthList = alist.groupBy { it }
            .map { entry -> entry.value.size }.sorted()
    val sliced = lengthList.slice(0..(lengthList.size - k - 1)).sum()
    println(sliced)
}

