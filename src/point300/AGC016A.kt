fun main(args: Array<String>) {
    val s = readLine()!!
    val typeNum = s.toCharArray().toSet().size
    var length = s.length
    var maxNum = s.toCharArray().groupBy { it }.maxBy { it.value.size }!!.value.size
    var i = 0
    while (true) {
        if (length <= maxNum) {
            println(i)
            return
        }
        i++
        length--
        maxNum *= 2
    }
}
