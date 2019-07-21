package participated.abc134

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toMutableList()
    aList.add(0, -1)
    val ansArray = IntArray(n + 2) { 0 }

    for (i in n downTo 1) {
        if (n / i <= 1) {
            ansArray[i] = aList[i]
        } else {
            var sum = 0
            for (j in 1..(n / i)) {
                sum += ansArray[i * j]
            }
            if (sum % 2 == aList[i]) {
                //do nothing
            } else {
                ansArray[i] = 1
            }
        }
    }
    val count = ansArray.count { it == 1 }
    println(count)
    if (count > 0) {
        for (i in 1..n) {
            if (ansArray[i] == 1) {
                print(i)
                print(" ")
            }
        }
        println()
    }
}
