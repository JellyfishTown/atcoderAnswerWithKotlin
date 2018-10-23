import java.util.*

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toLong)
    val map = TreeMap<Long, Long>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.split(" ").map(String::toLong)
        map[a] = b
    }
    var sum = 0L

    for(i in 1..k){
        val firstKey = map.firstKey()
        sum += firstKey
    }

}