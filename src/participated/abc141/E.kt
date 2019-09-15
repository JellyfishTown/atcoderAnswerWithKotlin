package participated.abc141

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    var maxLength = 0

    val next = Array(n+1) {
        val m = mutableMapOf<Char, Int>()
        ('a'..'z').forEach { m[it] = -1 }
        m
    }
    for (i in (n - 1) downTo 0) {
        for (j in 'a'..'z') {
            next[i][j] = next[i+1][j]!!
        }
        next[i][s[i]] = i
    }


    for (lStart in 0 until n - 1) {
        for (width in (maxLength + 1)..(n / 2)) {
            val lEnd = lStart + width
            if (lEnd > s.length) break
            val left = s.substring(lStart, lEnd)
            if(lEnd==n)break
            var rStart = next[lEnd][left.first()]!!
            if(rStart==-1)break
            while(true){
                val rEnd = rStart + width
                if (rEnd > s.length) break
                val right = s.substring(rStart, rEnd)
                if (left == right) {
                    maxLength = Math.max(maxLength, width)
                    break
                }
                rStart = next[rStart+1][left.first()]!!
            }
        }
    }
    println(maxLength)
}