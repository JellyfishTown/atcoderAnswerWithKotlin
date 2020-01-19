package participated.ext013

fun main(args: Array<String>) {
    val mod = 1000000007L
    fun calcFactorial(i: Long, skip: Long = 0): Long {
        return when {
            i == 1L -> 1L
            i == skip -> (calcFactorial(i - 1, skip)) % mod
            else -> (i * calcFactorial(i - 1, skip)) % mod
        }
    }

    val n = readLine()!!.toLong()
    val xList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    xList.add(0, 0)

    var ans = 0.0
    val jArray = DoubleArray(n.toInt()){1.0}
    for(j in 2 until n.toInt()){
        jArray[j] = jArray[j-1] + 1.0 / j.toDouble()
    }
    for (i in 1 until n.toInt()) {
        val tempj = jArray[i]
        ans += (xList[i + 1] - xList[i]).toDouble() * tempj
        ans %= mod
    }
    ans*=calcFactorial(n-1).toDouble()
    ans%=mod
    println(ans.toLong())
}