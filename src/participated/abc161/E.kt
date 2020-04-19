package participated.abc161

fun main(args: Array<String>) {
    val (n, k, c) = readLine()!!.split(' ').map(String::toInt)
    val s = readLine()!!
    val maruCount = IntArray(n + 1) { 0 }
    val lastMaru = IntArray(n + 1) { 0 }
    val nextMaru = IntArray(n + 2) { Int.MAX_VALUE }

    if (k == 1) {
        if (s.count { it == 'o' } == 1) {
            println(lastMaru[n])
        } else {

        }
        return
    }
    for (i in 1..n) {
        if (s[i - 1] == 'o') {
            maruCount[i] = maruCount[i - 1] + 1
            lastMaru[i] = i
        } else {
            maruCount[i] = maruCount[i - 1]
            lastMaru[i] = lastMaru[i - 1]
        }
    }

    for (i in n downTo 1) {
        if (s[i - 1] == 'o') {
            nextMaru[i] = i
        } else {
            nextMaru[i] = nextMaru[i + 1]
        }
    }

    val ansList = mutableListOf<Int>()
    var l = 1
    for (i in 0 until k) {
        val r = n - ((k - i) - 1) * (c + 1)
        val maruNum = maruCount[r] - maruCount[l - 1]
        val last = lastMaru[r]
        val next = nextMaru[l]
        if (maruNum == 1) {
            ansList.add(last)
        }
        l = next + c + 1
    }
    ansList.sorted().forEach {
        println(it)
    }
}
