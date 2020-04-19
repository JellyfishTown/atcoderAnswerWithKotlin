package participated.abc162

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toLong)
    val evenSumA = LongArray(n)
    val oddSumA = LongArray(n)
    evenSumA[0] = aList.first()
    oddSumA[0] = 0
    for (i in 1 until n) {
        if (i % 2 == 0) {
            evenSumA[i] = aList[i] + evenSumA[i - 1]
            oddSumA[i] = oddSumA[i - 1]
        } else {
            evenSumA[i] = evenSumA[i - 1]
            oddSumA[i] = aList[i] + oddSumA[i - 1]
        }
    }

    val evenSumAR = LongArray(n)
    val oddSumAR = LongArray(n)
    if (n % 2 == 1) {
        evenSumAR[n - 1] = aList.last()
        oddSumAR[n - 1] = 0
    } else {
        evenSumAR[n - 1] = 0
        oddSumAR[n - 1] = aList.last()
    }

    for (i in n - 2 downTo 0) {
        if (i % 2 == 0) {
            evenSumAR[i] = aList[i] + evenSumAR[0]
            oddSumAR[i] = oddSumAR[0]
        } else {
            evenSumAR[i] = evenSumAR[0]
            oddSumAR[i] = aList[i] + oddSumAR[0]
        }
    }

    if (n % 2 == 0) {
        val sum0 = aList.filterIndexed { index, l -> index % 2 == 0 }.sum()
        val sum1 = aList.filterIndexed { index, l -> index % 2 == 1 }.sum()
        var maxSum = Math.max(sum0, sum1)
        for (i in 1..n - 3 step 2) {
            val sum = evenSumA[i - 1] + oddSumAR[i + 2]
            maxSum = Math.max(maxSum, sum)
        }
        println(maxSum)
    } else {
        val sum0 = aList.filterIndexed { index, l -> index % 2 == 0 }.sum() - aList.last()
        val sum1 = aList.filterIndexed { index, l -> index % 2 == 0 }.sum() - aList.first()
        val sum2 = aList.filterIndexed { index, l -> index % 2 == 1 }.sum()
        var maxSum = Math.max(sum0, sum1)
        maxSum = Math.max(maxSum, sum2)
        for (i in 1..n - 4 step 2) {
            val sum = evenSumA[i - 1] + evenSumAR[i + 3]
            maxSum = Math.max(maxSum, sum)
        }
        for (i in 1..n - 3 step 2) {
            val sum = evenSumA[i - 1] + oddSumAR[i + 2]
            maxSum = Math.max(maxSum, sum)
        }
        for (i in 2..n - 3 step 2) {
            val sum = oddSumA[i - 1] + evenSumAR[i + 2]
            maxSum = Math.max(maxSum, sum)
        }
        println(maxSum)
    }
}
