package participated.abc151

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val psList = mutableListOf<Pair<Int, String>>()
    (1..m).forEach {
        val (p, s) = readLine()!!.split(' ')
        psList.add(Pair(p.toInt(), s))
    }
    psList.sortBy { it.first }
    val acList = IntArray(n+1){0}
    val waList = IntArray(n+1){0}
    for(i in 0 until m){
        val (p,s) = psList[i]
        if(s=="AC" && acList[p]==0){
            acList[p]=1
        }
        if(s =="WA" && acList[p]==0){
            waList[p]++
        }
    }

    var acCount = 0L
    var waCount = 0L
    for(i in 1..n){
        if(acList[i]>0){
            acCount++
            waCount+=waList[i]
        }
    }
    println("$acCount $waCount")
}