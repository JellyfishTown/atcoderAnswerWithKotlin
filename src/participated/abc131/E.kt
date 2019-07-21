package participated.abc131

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    val allHn = n * (n - 1) / 2
    if (k > allHn - (n - 1)) {
        println(-1)
        return
    }
    val hn = allHn - k

    val allH = mutableListOf<MutableList<Int>>()
    (1..n).forEach { allH.add(mutableListOf()) }

    for (i in 1 until n) {
        for (j in i + 1..n) {
            allH[i].add(j)
        }
    }
    var deleteNum = 0
    for (i in 1 until (n - 1)) {
        if (deleteNum == k) break
        for (j in i + 1 until n) {
            allH[i].remove(j)
            deleteNum++
            if (deleteNum == k) break
        }
        if (deleteNum == k) break
    }

    println(hn)
    for(i in 1 until n){
        for(j in allH[i]){
            println("$i $j")
        }
    }
}
