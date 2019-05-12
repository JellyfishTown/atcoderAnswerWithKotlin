package participated.ext008


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = Array(n) { readLine()!! }
    val countAB = sList.sumBy {
        var count = 0
        for (i in 0 until it.length - 1) {
            if (it[i] == 'A' && it[i + 1] == 'B') count++
        }
        count
    }
    val countBA = sList.count { it.first() == 'B' && it.last() == 'A' }
    val countLastA = sList.count { it.first() != 'B' && it.last() == 'A' }
    val countFirstB = sList.count { it.first() == 'B' && it.last() != 'A' }
    if (countBA > 0) {
        if (countLastA > 0 && countFirstB > 0) {
            println(countAB
                    + countBA - 1
                    + 2
                    + Math.min(countLastA - 1, countFirstB - 1))
        } else {
            println(countAB
                    + countBA - 1
                    + if (countLastA > 0 || countFirstB > 0) 1 else 0)
        }
    } else if (countFirstB > 0 && countLastA > 0) {
        println(countAB + Math.min(countLastA, countFirstB))
    } else {
        println(countAB)
    }
}
