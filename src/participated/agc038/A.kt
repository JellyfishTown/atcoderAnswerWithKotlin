package participated.agc038

fun main(args: Array<String>) {
    val (h, w, a, b) = readLine()!!.split(' ').map(String::toLong)
    val aPat = mutableListOf<Triple<Long, Long, Long>>()
    val bPat = mutableListOf<Triple<Long, Long, Long>>()

    if (h == 1L) {
        if (b != 0L) {
            println("No")
            return
        } else {
            for (i in 0 until w) {
                if (i < a) {
                    print(1)
                } else {
                    print(0)
                }
            }
            println()
            return
        }
    }
    if (w == 1L) {
        if (a != 0L) {
            println("No")
            return
        } else {
            for (i in 0 until h) {
                if (i < b) {
                    println(1)
                } else {
                    println(0)
                }
            }
            return
        }
    }
    for (i in 1 until h) {
        val oneNum = (h - i) * a + i * (w - a)
        aPat.add(Triple(i, oneNum, h * w - oneNum))
    }
    for (i in 1 until w) {
        val oneNum = (w - i) * b + i * (h - b)
        bPat.add(Triple(i, oneNum, h * w - oneNum))
    }
    var oNum = -1L
    for ((i1, a1, b1) in aPat) {
        if (oNum != -1L) break
        for ((i2, a2, b2) in bPat) {
            if (a1 == a2 && b1 == b2) {
                oNum = i1
                break
            }
        }
    }
    if (oNum == -1L) {
        println("No")
        return
    }
    for (i in 0 until h) {
        var line = ""
        for (j in 0 until w) {
            if (oNum > 0 && j < w - a) {
                line+="1"
            } else if (oNum > 0) {
                line+="0"
            } else if (j < w - a) {
                line+="0"
            } else {
                line+="1"
            }
        }
        oNum--
        println(line)
    }
}