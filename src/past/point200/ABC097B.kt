package past.point200

fun main(args: Array<String>) {
    val x = readLine()!!.toInt()
    val bekiList = mutableSetOf<Int>()
    bekiList.add(1)
    for (i in 2..34) {
        var p = 2
        while (Math.pow(i.toDouble(), p.toDouble()) <= 1000) {
            bekiList.add(Math.pow(i.toDouble(), p.toDouble()).toInt())
            p++
        }
    }
    println(bekiList.filter { it <= x }.max())
}

