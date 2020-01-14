package past.point300

//https://atcoder.jp/contests/nikkei2019-2-final/tasks/nikkei2019_2_final_b
fun main(args: Array<String>) {
    val s = readLine()!!
    val l = s.length
    var count = 0
    for (i1 in 1..(l - 5)) {
        for (i2 in 1..(l - i1 - 3) / 2) {
            for (i3 in 1..(l - i1 - i2 * 2 - 1) / 2) {
                val i4 = i3
                val i5 = l - i1 - i2 * 2 - i3 * 2
                val i6 = i2
                val s1 = s.substring(0, i1)
                val s2 = s.substring(i1, i1 + i2)
                val s3 = s.substring(i1 + i2, i1 + i2 + i3)
                val s4 = s.substring(i1 + i2 + i3, i1 + i2 + i3 + i4)
                val s5 = s.substring(i1 + i2 + i3 + i4, i1 + i2 + i3 + i4 + i5)
                val s6 = s.substring(i1 + i2 + i3 + i4 + i5, i1 + i2 + i3 + i4 + i5 + i6)
                if (s2 == s6 && s3 == s4) {
//                    println("$s1 $s2 $s3 $s4 $s5 $s6")
                    count++
                }
            }
        }
    }
    println(count)
}
