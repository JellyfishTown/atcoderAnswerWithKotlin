package participated.abc142

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val boxKey = Array(n + 1) { mutableListOf<Int>() }
    val keyCost = Array(m + 1) { Long.MAX_VALUE / n }
    val keyBox = Array(m + 1) { mutableListOf<Int>() }

    for (i in 1..m) {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
        keyCost[i] = a
        val cList = readLine()!!.split(' ').map(String::toInt)
        cList.forEach {
            boxKey[it].add(i)
            keyBox[i].add(it)
        }
    }
    val ans = Array(n + 1) { 0 }

    for (tb in 1..n) {
        for (k in 1..m) {
            if (keyBox[k].contains(tb)) {
                if (keyCost[ans[tb]] > keyCost[k]) {
                    ans[tb] = k
                }
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if(ans[i]==0||ans[j]==0)continue
            val con1 = keyBox[ans[i]].containsAll(keyBox[ans[j]])
            val con2 = keyBox[ans[j]].containsAll(keyBox[ans[i]])
            if (con1) {
                ans[j] = ans[i]
            } else if (con2) {
                ans[i] = ans[j]
            }
        }
    }

    for (tb in 1..n) {
        for (k in 1..m) {
            val boxes = keyBox[k].toSet()
            val keys = boxes.map { ans[it] }.toSet()
            if(keys.contains(k))continue
            val dupBox = keys.flatMap { keyBox[it] }.toSet()
            if (boxes.size != dupBox.size) continue
            val curCost = keys.map { keyCost[it] }.sum()
            if (curCost > keyCost[k]) {
                boxes.forEach { ans[it] = k }
            }
        }
    }


    val ansSet = ans.takeLast(n).toSet()
    if (ansSet.contains(0)) {
        println(-1)
    } else {
        println(ansSet.map { keyCost[it] }.sum())
    }
}