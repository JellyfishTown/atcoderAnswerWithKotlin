package past.point500

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val ansList = mutableListOf<Pair<Int, Int>>()
    var ll = 1
    var lr = ll + m
    var rl = lr + 1
    var rr = rl + m - 1
    while (ll < lr) {
        ansList.add(Pair(ll++, lr--))
    }
    while (rl < rr) {
        ansList.add(Pair(rl++, rr--))
    }

    for (i in 0 until m) {
        println(ansList[i].first.toString() + " " + ansList[i].second)
    }
}
