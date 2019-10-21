package past.other.internal.m5

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = "x" + readLine()!!
    val arr = Array(n + 1) { 0 }
    val step1 = (n + 1) / 2

    var li = 1
    var ri = n
    for (i in 1..step1) {
        if (s[i] == 'L') {
            arr[li] = i
            li += 2
        } else {
            arr[ri] = i
            ri -= 2
        }
    }
    li = if (arr[1] == 0) 1 else 2
    ri = if (arr[n] == 0) n else n - 1
    for (i in (step1 + 1)..n) {
        if (s[i] == 'L') {
            while(arr[li]!=0){
                li++
            }
            arr[li] = i
        } else {
            while(arr[ri]!=0){
                ri--
            }
            arr[ri] = i
        }
    }
    val ansList = mutableListOf<Pair<Int,Int>>()
    for(i in 1..n){
        ansList.add(Pair(i,arr[i]))
    }
    ansList.sortBy { it.second }
    for(ans in ansList){
        println(ans.first)
    }
}