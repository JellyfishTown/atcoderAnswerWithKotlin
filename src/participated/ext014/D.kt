package participated.ext014

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(' ').map(String::toInt).toIntArray()
    val bList = readLine()!!.split(' ').map(String::toInt).toIntArray()

    if(n==1){
        println(0)
        return
    }
    var ans = Int.MAX_VALUE
    fun execute(start: Int, omote: Boolean, kaisu: Int, aListTemp: IntArray, bListTemp: IntArray, curmin: Int) {
        val aListCopy = aListTemp.clone()
        val bListCopy = bListTemp.clone()
        if (start == n - 1) {
            if ((0..(n - 2)).all { aListCopy[it] <= aListCopy[it + 1] }) {
                ans = Math.min(ans, kaisu)
            }
            return
        }
        var min = if (start % 2 == if (omote) 0 else 1) {
            aListCopy[start]
        } else {
            Int.MAX_VALUE
        }
        var mini = -1
        if (omote) {
            for (i in start until n) {
                if (i % 2 != start % 2) continue
                if (aListCopy[i] in curmin until min) {
                    min = aListCopy[i]
                    mini = i
                }
            }
        } else {
            for (i in start until n) {
                if (i % 2 == start % 2) continue
                if (bListCopy[i] in curmin until min) {
                    min = bListCopy[i]
                    mini = i
                }
            }
        }
        if (mini == -1) {
            mini = start
        } else if (mini == start) {
            //do nothing
        } else {
            for (i in mini downTo start + 1) {
                val tampa = aListCopy[i - 1]
                val tampb = bListCopy[i - 1]
                aListCopy[i - 1] = bListCopy[i]
                bListCopy[i - 1] = aListCopy[i]
                aListCopy[i] = tampb
                bListCopy[i] = tampa
            }
        }
        execute(start + 1, true, kaisu + (mini - start), aListCopy, bListCopy, aListCopy[start])
        execute(start + 1, false, kaisu + (mini - start), aListCopy, bListCopy, aListCopy[start])
    }
    execute(0, true, 0, aList, bList, 0)
    execute(0, false, 0, aList, bList, 0)
    println(if (ans == Int.MAX_VALUE) -1 else ans)
}
