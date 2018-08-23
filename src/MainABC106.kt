fun main(args: Array<String>) {
    val (n, m, q) = readLine()!!.split(' ').map(String::toInt)
    val map = mutableMapOf<Int, MutableMap<Int, Int>>()
    for (i in 1..m) {
        val (l, r) = readLine()!!.split(' ').map(String::toInt)
        for (j in 1..l) {
            if (map.containsKey(j).not()) {
                map[j] = mutableMapOf()
            }
            for (k in r..n) {
                map[j]!![k] = (map[j]!![k] ?: 0) + 1
            }
        }

    }
    for (i in 1..q) {
        val (pi, qi) = readLine()!!.split(' ').map(String::toInt)
        println(map[pi]!![qi])
    }
}

//fun main(args: Array<String>) {
//    val s = readLine()!!
//    val k = readLine()!!.toLong()
//    var oneLength = 0
//    for (c in s) {
//        if (c == '1') {
//            oneLength++
//        } else {
//            break
//        }
//    }
//
//    if (k == 1L) {
//        println(s[0])
//    } else if (k <= oneLength) {
//        println(1)
//    } else {
//        println(s[oneLength])
//    }
//}

//fun main(args: Array<String>) {
//    val n = readLine()!!.toInt()
//    var count = 0
//    for (i in 1..n) {
//        if (i % 2 == 0) continue
//        var tempCount = 0
//        for (j in 1..i) {
//            if (i % j == 0) tempCount++
//        }
//        if (tempCount == 8) count++
//    }
//    println(count)
//}


//fun main(args: Array<String>) {
//    val (a,b) = readLine()!!.split(' ').map(String::toInt)
//    val answer = a * b - a - b + 1
//    println(answer)
//}
