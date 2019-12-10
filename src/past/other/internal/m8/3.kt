package past.other.internal.m8

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val sList = mutableListOf<String>()
    (1..n).forEach { sList.add(readLine()!!.toCharArray().sortedArray().joinToString("")) }
    sList.sortBy { it }
    sList.sortBy { it.length }

    if (n == 1) {
        println(0)
        return
    }

    var ans = 0L
    var l = 0
    var r = 1
    var con = 0L
    while (true) {
        if (r >= n || l == r){
            ans += (con * (con + 1L)) / 2L
            break
        }
        if (sList[l] == sList[r]) {
            r++
            con++
        } else {
            ans += (con * (con + 1L)) / 2L
            con = 0
            l = r
            r = l + 1
        }
    }
    println(ans)
}
