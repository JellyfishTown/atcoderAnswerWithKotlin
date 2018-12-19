package util

import java.util.*
import kotlin.system.measureTimeMillis

//条件式を適用した結果も{False,False,True,True}の様にソートされているもののみに適用可能であり、
//{False,True,False,True}の様になる場合は適用不可
inline fun <T> List<T>.indexOfFirstByBinary(predicate: (T) -> Boolean): Int {
    var left = 0
    var right = size - 1
    while (left < right) {
        if (predicate(this[left])) {
            return left
        }
        if (!predicate(this[right])) {
            return -1
        }
        val middle = ((left + right) / 2)
        if (predicate(this[middle])) {
            right = middle
        } else {
            left = middle + 1
        }
    }
    return if (predicate(this[left])) left else -1
}

fun main(args: Array<String>) {
    val k = 2000
    val pList = mutableListOf<Int>()
    for (i in 1..k) {
        for (j in 1..i) {
            pList.add(i)
        }
    }
    val t1 = measureTimeMillis {
        for (i in 1..k) {
            val tmp = pList.indexOfFirstByBinary { it > i }
        }
    }
    val t2 = measureTimeMillis {
        for (i in 1..k) {
            val tmp = pList.indexOfFirst { it > i }
        }
    }

    println(t1.toString() + ":" + t2.toString())
}
