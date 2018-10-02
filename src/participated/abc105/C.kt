fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    if (n == 0L) {
        println(0)
        return
    }
    var base = 2L
    var plusFlg = if (n > 0) 1L else -1L
    var rest = n
    val result = mutableListOf<Int>()

    while (rest != 0L) {
        if (rest % base != 0L) {
            rest -= (rest % base) * plusFlg
            result.add(1)

        } else {
            result.add(0)
        }
        plusFlg *= -1L
        base *= -2
    }
    result.reversed().forEach { print(it) }
    println()
}
