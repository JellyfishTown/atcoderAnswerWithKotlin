package participated

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    var count = 0
    val min = Math.min(n, m)
    val max = Math.max(n, m)
    val dp = Array(1000) { arrayOfNulls<Boolean>(1000) }
    for (x in 12..min) {
        for (y in x..max) {
            var tempX = x
            var tempY = y
            var loopFlg = true
            val processList = mutableListOf<Pair<Int, Int>>()
            processList.add(Pair(x, y))
            for (i in 1..1000) {
                val calc = calc(tempX, tempY)
                if (calc == null) {
                    loopFlg = false
                    break
                }
                processList.add(calc)
                tempX = calc.first
                tempY = calc.second

                if (dp[tempX][tempY] == true) {
                    break
                } else if (dp[tempX][tempY] == false) {
                    loopFlg = false
                    break
                }
            }
            if (loopFlg) {
                for (p in processList) {
                    dp[p.first][p.second] = true
                }
                count += if (x == y || y > min) 1 else 2
            } else {
                for (p in processList) {
                    dp[p.first][p.second] = false
                }
            }
        }
    }
    println(count)
}

fun calc(v1: Int, v2: Int): Pair<Int, Int>? {
    var x = v1
    var y = v2
    if (x == 0 || y == 0) return null
    if (x < y) {
        x = rev(x)
    } else {
        y = rev(y)
    }
    if (x < y) {
        y = Math.max(x, y) - Math.min(x, y)
    } else {
        x = Math.max(x, y) - Math.min(x, y)
    }
    return Pair(x, y)
}

fun rev(i: Int): Int {
    return i.toString().toCharArray().reversed().joinToString(separator = "").toInt()
}

//fun participated.abc106.participated.abc104.participated.main(args: Array<String>) {
//    var count = readLine()!!.toInt()
//    val sList = readLine()!!.toCharArray()
//    if (count <= 0) {
//        println("Yes")
//        return
//    }
//    for (s in sList) {
//        if (s == '+') {
//            count++
//        } else {
//            count--
//        }
//        if (count <= 0) {
//            println("Yes")
//            return
//        }
//    }
//    println("No")
//}


