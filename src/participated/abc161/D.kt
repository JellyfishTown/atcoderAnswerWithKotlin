package participated.abc161

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val ansSet = Array(11) { mutableSetOf<String>() }
    (1..9).forEach { ansSet[1].add(it.toString()) }

    for (i in 2..10) {
        for (v in ansSet[i - 1]) {
//            left
            val lv = v.first().toString().toInt()
            if (lv != 1) ansSet[i].add((lv - 1).toString() + v)
            ansSet[i].add(lv.toString() + v)
            if (lv != 9) ansSet[i].add((lv + 1).toString() + v)

//            right
            val rv = v.last().toString().toInt()
            if (rv != 0) ansSet[i].add(v + (rv - 1).toString())
            ansSet[i].add(v + rv.toString())
            if (rv != 9) ansSet[i].add(v + (rv + 1).toString())
        }
    }
    val ansList = (1..10).flatMap {x->
        ansSet[x].map { it.toLong() }
    }
    println(ansList.sorted()[k - 1])
}
