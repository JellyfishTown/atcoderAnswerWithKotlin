package participated.abc141

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var max = 0
    var tmp = 0
    var target = ""
    for (i in 0 until n) {
        var j = max
        while (i + j < n) {
            target = s.substring(i, i + j + 1)
            tmp = s.lastIndexOf(target)
            if (tmp != i && tmp > i + j) {
                max = j + 1
            } else {
                break
            }
            j++
        }
    }
    println(max)
}
