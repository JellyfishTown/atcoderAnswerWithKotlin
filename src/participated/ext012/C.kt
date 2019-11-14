package participated.ext012

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val bList = readLine()!!.split(' ').map(String::toLong)
    val abList = (0 until n).map { Pair(aList[it], bList[it]) }.sortedBy { it.second }

    val aSorted = aList.sorted()
    val bSorted = bList.sorted()

    if ((0 until n).any { aSorted[it] > bSorted[it] }) {
        println("No")
        return
    }

    val aStart =  (0 until n).map {abList[it].first }
    val aStartWithIndex =  (0 until n).map {Pair(aStart[it],it) }.sortedBy { it.first }
    val visited = Array(n){false}
    var visitedCount = 1
    var cur = 0
    while(!visited[cur]){
        visited[cur] = true
        visitedCount++
        cur = aStartWithIndex[cur].second
    }

    if(visitedCount<n){
        println("Yes")
        return
    }

    if ((0 until n-1).any { bSorted[it] > aSorted[it+1] }) {
        println("Yes")
    }else{
        println("No")
    }
}
