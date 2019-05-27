package participated.abc128

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)

    val kList = mutableListOf<Int>()
    val sMap = mutableMapOf<Int, List<Int>>()
    for (i in 1..m) {
        val input = readLine()!!.split(' ').map(String::toInt)
        val k = input[0]
        kList.add(k)
        sMap[i] = input.takeLast(k)
    }
    val pList = readLine()!!.split(' ').map(String::toInt)

    val last = Math.pow(2.0, n.toDouble()).toInt() - 1
    var ans = 0
    for (i in 0..last) {
        val charArray = String.format("%010d", Integer.toBinaryString(i).toInt()).toCharArray().reversedArray()
        var allTrue = true
        for (j in 1..m) {
            var sum = 0
            for (s in sMap[j]!!) {
                sum += charArray[s - 1].toInt()
            }
            if (sum % 2 != pList[j - 1]) {
                allTrue = false
                break
            }
        }
        if (allTrue) ans++
    }

    println(ans)
}
