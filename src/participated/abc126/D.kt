package participated.abc126

var color = Array(1) { 0 }
var inTree = Array(1) { false }
var evenTree = mutableMapOf<Int, MutableList<Int>>()
var oddTree = mutableMapOf<Int, MutableList<Int>>()

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    color = Array(n + 1) { 0 }
    inTree = Array(n + 1) { false }
    for (i in 1 until n) {
        val (u, v, w) = readLine()!!.split(' ').map(String::toInt)
        if (w % 2 == 0) {
            if(evenTree.containsKey(u)){
                evenTree[u]!!.add(v)
            }else{
                evenTree[u] = mutableListOf(v)
            }
            if(evenTree.containsKey(v)){
                evenTree[v]!!.add(u)
            }else{
                evenTree[v] = mutableListOf(u)
            }
        } else {
            if(oddTree.containsKey(u)){
                oddTree[u]!!.add(v)
            }else{
                oddTree[u] = mutableListOf(v)
            }
            if(oddTree.containsKey(v)){
                oddTree[v]!!.add(u)
            }else{
                oddTree[v] = mutableListOf(u)
            }
        }
    }
    paint(1, 0)


    for(i in 1..n){
        println(color[i])
    }
}

fun paint(target: Int, curColor: Int) {
    inTree[target] = true
    color[target] = curColor

    for (t in evenTree[target]?: emptyList<Int>()) {
        if (!inTree[t]) {
            paint(t, curColor)
        }
    }
    for (t in oddTree[target]?: emptyList<Int>()) {
        if (!inTree[t]) {
            paint(t, (curColor + 1) % 2)
        }
    }
}