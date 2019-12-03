package past.point400


fun main(args: Array<String>) {
    val (h, w, n) = readLine()!!.split(' ').map(String::toLong)
    val abMap = mutableMapOf<Pair<Long, Long>, Boolean>()
    val abList = (1..n).map {
        val (a, b) = readLine()!!.split(' ').map(String::toLong)
//        abMap[Pair(a, b)] = false
        Pair(a, b)
    }


    val total = (h - 2) * (w - 2)
    val ansArray = LongArray(10) { 0 }
    ansArray[0] = total

    for (ab in abList) {
        val (a, b) = ab
        for (dw in -1..1) {
            for (dh in -1..1) {
                if (a + dh - 1 < 1) continue
                if (a + dh + 1 > h) continue
                if (b + dw - 1 < 1) continue
                if (b + dw + 1 > w) continue

                var count = 0
                for (dw2 in -1..1) {
                    for (dh2 in -1..1) {
                        val th = a + dh + dh2
                        val tw = b + dw + dw2
                        if (th == a && tw == b) continue
                        if (abMap[Pair(th, tw)] != null) {
                            count++
                        }

                    }
                }
                ansArray[count]--
                ansArray[count + 1]++
            }
        }
        abMap[Pair(a, b)] = false
    }

    (0..9).forEach { println(ansArray[it]) }
}
