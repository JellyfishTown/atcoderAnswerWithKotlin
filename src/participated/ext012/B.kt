package participated.ext012

fun main(args: Array<String>) {
    val mod = 998244353L
    val n = readLine()!!.toInt()
    val d = readLine()!!.split(' ').map(String::toInt)
    if (d[0] != 0 || d.count { it == 0 } != 1) {
        println(0)
        return
    }
    val da = IntArray(n)
    d.forEach { da[it]++ }
    var ans = 1L
    val max = d.max()!!
    for(i in 1..max){
        for (j in 1..da[i]) {
            ans *= da[i - 1].toLong()
            ans %= mod
        }
    }
    println(ans)
}

fun main2(args: Array<String>) {
    val mod = 998244353L
    val n = readLine()!!.toInt()
    val dList = readLine()!!.split(" ").map { it.toInt() }
    if (dList[0] != 0 || dList.count { it == 0 } != 1) {
        println(0)
        return
    }
    val distCnt = IntArray(n)
    val maxDist = dList.max()!!
    dList.forEach { distCnt[it]++ }
    var ans = 1L
    for (i in 1..maxDist) {
        for (k in 1..distCnt[i]) {
            ans *= distCnt[i - 1].toLong()
            ans %= mod
        }
    }
    println(ans)
}
