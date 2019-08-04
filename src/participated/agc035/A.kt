package participated.agc035

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)

    if (aList.all { it == 0L }) {
        println("Yes")
        return
    }
    if (n % 3 != 0) {
        println("No")
        return
    }

    val aGroup = aList.groupBy { it }
    if (aGroup.size == 2 && aGroup[0]!!.size == n / 3) {
        println("Yes")
        return
    }
    if (aGroup.size == 3) {
        val (k1, k2, k3) = aGroup.keys.toList()
        if ((k1 xor k2 xor k3) == 0L
                && aGroup[k1]!!.size == aGroup[k2]!!.size
                && aGroup[k1]!!.size == aGroup[k3]!!.size) {
            println("Yes")
            return
        }
    }
    println("No")
}
