package point300

import java.util.TreeSet

fun main(args: Array<String>) {
    val s = readLine()!!
    val k = readLine()!!.toInt()
    val n = s.length - 1

    val substringSet = TreeSet<String>()
    for (i in 0..n) {
        var count = 0
        for (j in i..n) {
            if (count >= 5) break
            substringSet.add(s.slice(i..j))
            count++
        }
    }
    println(substringSet.toList()[k - 1])
}

