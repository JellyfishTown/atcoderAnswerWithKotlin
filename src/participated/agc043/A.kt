package participated.agc043

import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {
    data class Node(
            val th:Int,
            val tw:Int,
            val cost:Int,
            val from:Char
    )
    val (h,w) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(h+2){ mutableListOf<Char>()}
    val costMap = Array(h+2){ mutableListOf<Int>()}
    map[0]= CharArray(w+2){'x'}.toMutableList()
    costMap[0]= IntArray(w+2){0}.toMutableList()
    (1..h).map {
        val temp = readLine()!!.toCharArray().toMutableList()
        temp.add(0,'x')
        temp.add('x')
        map[it] = temp
        costMap[it]= IntArray(w+2){0}.toMutableList()
    }
    map[h+1]= CharArray(w+2){'x'}.toMutableList()
    costMap[h+1]= IntArray(w+2){0}.toMutableList()


    //th,tw,cost
    val queue = PriorityQueue<Node>( Comparator { o1: Node?, o2: Node? ->
        if (o1!!.cost > o2!!.cost) 1 else -1
    })
    if(map[1][1]=='#'){
        costMap[1][1] = 1
    }


    println()
}
