package past.other.past

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val cList = readLine()!!.split(' ').map(String::toLong).toMutableList()
    cList.add(0, Long.MAX_VALUE)

    var minValue = cList.min()!!
    var oddMinValue = cList.filterIndexed { index, l -> index % 2 == 1 }.min()!!
    val oddNum = (n + 1) / 2

    val q = readLine()!!.toInt()
    var ans = 0L
    var allMinus = 0L
    var oddMinus = 0L
    (1..q).map {
        val s = readLine()!!.split(' ')
        when (s[0]) {
            "1" -> {
                val x = s[1].toInt()
                val a = s[2].toInt()
                val minus = allMinus + if (x % 2 == 1) oddMinus else 0
                if (cList[x] - minus >= a) {
                    cList[x] = cList[x] - a
                    ans += a
                    if (x % 2 == 1) oddMinValue = Math.min(oddMinValue,cList[x])
                    minValue = Math.min(minValue,cList[x])
                }
            }
            "2" -> {
                val a = s[1].toInt()
                if (oddMinValue >= a) {
                    oddMinValue -= a
                    ans += a * oddNum
                    minValue = Math.min(minValue, oddMinValue)
                    oddMinus += a
                }
            }
            else -> {
                val a = s[1].toInt()
                if (minValue >= a) {
                    minValue -= a
                    oddMinValue -= a
                    ans += a * n
                    allMinus += a
                }
            }
        }
    }
    println(ans)
}
