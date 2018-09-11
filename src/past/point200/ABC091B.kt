package past.point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = mutableMapOf<String, Int>()
    for (i in 1..n) {
        val tempS = readLine()!!
        if (s.containsKey(tempS)) {
            s[tempS] = s[tempS]!! + 1
        } else {
            s[tempS] = 1
        }
    }

    val m = readLine()!!.toInt()
    val t = mutableMapOf<String, Int>()
    for (i in 1..m) {
        val tempT = readLine()!!
        if (t.containsKey(tempT)) {
            t[tempT] = t[tempT]!! + 1
        } else {
            t[tempT] = 1
        }
    }

    var max = 0
    for(key in s.keys){
        val temp = if (t.containsKey(key)) t[key]!! else 0
        max = Math.max(max, s[key]!! - temp)
    }
    println(max)
}