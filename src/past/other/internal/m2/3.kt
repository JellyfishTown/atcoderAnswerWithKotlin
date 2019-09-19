package past.other.internal.m2

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val inputList = mutableListOf<Map<Int, Double>>()
    val xSet = mutableSetOf<Int>()
    (1..n).forEach {
        val input = readLine()!!.split(' ').map(String::toInt)
        val m = input[0]
        val last = input.takeLast(m)
        val map = mutableMapOf<Int, Double>()
        last.toSet().forEach { s ->
            map[s] = last.count { l -> l == s }.toDouble() / m.toDouble()
        }
        inputList.add(map)
        xSet.addAll(last)
    }
    val ans = mutableMapOf<Int, Double>()
    xSet.forEach { ans[it] = 0.0 }
    for (input in inputList) {
        for (x in xSet) {
            ans[x] = ans[x]!! + (1 - ans[x]!!) * (input[x]?:0.0)
        }
    }
    println(ans.values.sum())
}
