package past.point300


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = mutableListOf<String>()
    for (i in 1..n) {
        aList.add(readLine()!!)
    }

    val map = mutableMapOf<Char, Int>()
    aList[0].toCharArray().sorted().forEach { map[it] = (map[it] ?: 0) + 1 }

    for (i in 1 until n) {
        for ((key, value) in map) {
            val count = aList[i].count { it == key }
            if (count < value) map[key] = count
        }
    }

    for ((key, value) in map) {
        for(i in 0 until value){
            print(key)
        }
    }
    println()
}
