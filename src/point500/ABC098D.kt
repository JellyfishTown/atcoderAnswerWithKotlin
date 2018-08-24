//http://seica-at.hatenablog.com/entry/2018/05/27/024754
//を参考にコード記述
//未完成
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toInt)

    var r = 0
    var currentSum = 0
    var currentXor = 0
    var ans = 0
    for (l in 0..(n - 1)) {
        while (r < n && (currentSum + aList[r]) == (currentXor xor aList[r])) {
            currentSum += aList[r]
            currentXor = currentXor xor aList[r]
            r++
        }
        ans += r - l
        currentSum -= aList[l]
        currentXor = currentXor xor aList[l]
    }

    println(ans)
}

fun main2(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map(String::toInt)

    var count = 0
    var bj = 0
    for (i in 0..(n - 1)) {
        for (j in i..(n - 1)) {
            count += if (check(aList.subList(i, j + 1))) 1 else 0
        }
    }
    println(count)
}

fun check(aList: List<Int>): Boolean {
    if (aList.size == 1) return true
    var xorSum = aList[0]
    var sum = aList[0]
    for (i in 1..(aList.size - 1)) {
        xorSum = xorSum xor aList[i]
        sum += aList[i]
    }
    return xorSum == sum
}
