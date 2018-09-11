package past.point300

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val inputList = readLine()!!.split(' ').map(String::toInt)
    val map = mutableMapOf<Int, Int>()
    inputList.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    var maxSum = 0
    for (key in map.keys) {
        var sum = 0
        sum += map[key]!!
        if (map[key + 1] != null) sum += map[key + 1]!!
        if (map[key + 2] != null) sum += map[key + 2]!!
        maxSum = Math.max(maxSum, sum)
    }
    println(maxSum)
}
