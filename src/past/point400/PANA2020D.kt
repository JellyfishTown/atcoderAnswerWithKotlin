package past.point400

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = "xabcdefghij"
    var ansList1 = mutableListOf<Pair<String, Int>>()
    ansList1.add(Pair("a", 1))
    for (i in 2..n) {
        val ansList2 = mutableListOf<Pair<String, Int>>()
        for (ans in ansList1) {
            for (j in 1..i) {
                if (ans.second + 1 == j) {
                    ansList2.add(Pair(ans.first + s[j], ans.second + 1))
                } else if (ans.second >= j) {
                    ansList2.add(Pair(ans.first + s[j], ans.second))
                }else{
                    break
                }
            }
        }
        ansList1 = ansList2
    }
    ansList1.forEach { println(it.first) }
}
