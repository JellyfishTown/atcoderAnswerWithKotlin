package participated.abc129

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val sMap = Array(h) { CharArray(w) }
    (0 until h).forEach { sMap[it] = readLine()!!.toCharArray() }

    val lMap = Array(h) { IntArray(w) { 0} }
    for (th in 0 until h) {
        for (tw in 0 until w) {
            if (sMap[th][tw] == '#') continue
            if (tw == 0) {
                lMap[th][tw] = 1
            } else {
                lMap[th][tw] = lMap[th][tw - 1] + 1
            }
        }
    }

    val rMap = Array(h) { IntArray(w) { 0 } }
    for (th in 0 until h) {
        for (tw in (w - 1) downTo 0) {
            if (sMap[th][tw] == '#') continue
            if (tw == w - 1) {
                rMap[th][tw] = 1
            } else {
                rMap[th][tw] = rMap[th][tw + 1] + 1
            }
        }
    }

    val uMap = Array(h) { IntArray(w) { 0} }
    for (tw in 0 until w) {
        for (th in (h - 1) downTo 0) {
            if (sMap[th][tw] == '#') continue
            if (th == h - 1) {
                uMap[th][tw] = 1
            } else {
                uMap[th][tw] = uMap[th + 1][tw] + 1
            }
        }
    }

    val dMap = Array(h) { IntArray(w) { 0 } }
    for (tw in 0 until w) {
        for (th in 0 until h) {
            if (sMap[th][tw] == '#') continue
            if (th == 0) {
                dMap[th][tw] = 1
            } else {
                dMap[th][tw] = dMap[th - 1][tw] + 1
            }
        }
    }

    var max = 0
    for (tw in 0 until w) {
        for (th in 0 until h) {
            if (sMap[th][tw] == '#') continue
            max = Math.max(max, rMap[th][tw] + lMap[th][tw] + uMap[th][tw] + dMap[th][tw] - 3)
        }
    }
    println(max)
}