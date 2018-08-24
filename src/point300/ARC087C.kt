package point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val alist = readLine()!!.split(' ').map(String::toInt)

    var count = 0
    val map = alist.groupBy { it }
    for (key in map.keys) {
        val filtered = map[key]!!.size
        if (filtered > key) {
            count += filtered - key
        } else if (filtered < key) {
            count += filtered
        }
    }
    println(count)
}

