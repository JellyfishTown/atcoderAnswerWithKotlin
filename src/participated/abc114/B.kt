package participated.abc114

fun main(args: Array<String>) {
    val s = readLine()!!
    var min = Integer.MAX_VALUE
    for (i in 0..(s.length - 3)) {
        min = Math.min(min, Math.abs(s.substring(i, i + 3).toInt()-753))
    }
    print(min)
}


