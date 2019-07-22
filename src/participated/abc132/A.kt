package participated.abc132

fun main(args: Array<String>) {
    val s = readLine()!!
    val map = mutableMapOf<Char, Int>()
    s.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }
    if (map.size == 2 && map.all { it.value == 2 }) {
        println("Yes")

    } else {
        println("No")
    }
}
