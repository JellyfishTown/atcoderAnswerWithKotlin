fun main(args: Array<String>) {
    val x = readLine()!!.toInt()
    val dAccum = mutableListOf(0L)
    for (i in 1..100000) {
        dAccum.add(dAccum[i - 1] + i)
    }
    println(dAccum.filter { it < x }.size)
}

