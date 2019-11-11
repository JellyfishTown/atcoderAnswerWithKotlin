package participated.agc040

fun main(args: Array<String>) {
    val s = readLine()!!
    val n = s.length + 1
    val leftArray = Array(n) { 0L }
    val rightArray = Array(n) { 0L }
    var c = 0L
    (1 until n).forEach {
        c = if (s[it - 1] == '<') c + 1 else 0
        leftArray[it] = c
    }
    c = 0L
    (n - 2 downTo 0).forEach {
        c = if (s[it] == '>') c + 1 else 0
        rightArray[it] = c
    }
    println((0 until n).map { Math.max(leftArray[it], rightArray[it]) }.sum())
}
//
//fun main(args: Array<String>) {
//    val s = readLine()!!
//    val n = s.length + 1
//    val ansArray = Array(n) { 0L }
//
//    var cur = 2L
//    var j = 1
//    if (s.first() == '<') {
//        ansArray[0] = 0
//        ansArray[1] = 1
//        cur = 2L
//        j = 1
//        while (true) {
//            if (j >= s.length || s[j] != '<') break
//            ansArray[j + 1] = Math.max(cur, ansArray[j + 1])
//            j++
//            cur++
//        }
//    }
//
//    if (s.last() == '>') {
//        ansArray[n - 1] = Math.max(0,ansArray[n - 1])
//        ansArray[n - 2] = Math.max(1,ansArray[n - 2])
//        cur = 2L
//        j = s.length - 2
//        while (true) {
//            if (j < 0 || s[j] != '>') break
//            ansArray[j] = Math.max(cur, ansArray[j])
//            j--
//            cur++
//        }
//    }
//
//    for (i in 0..(s.length - 2)) {
//        if (s[i] == '>' && s[i + 1] == '<') {
//            ansArray[i] = Math.max(1, ansArray[i])
//            ansArray[i + 1] = Math.max(0, ansArray[i + 1])
//            ansArray[i + 2] = Math.max(1, ansArray[i + 2])
//
//            cur = 2L
//            j = i - 1
//            while (true) {
//                if (j < 0 || s[j] != '>') break
//                ansArray[j] = Math.max(cur, ansArray[j])
//                j--
//                cur++
//            }
//            cur = 2L
//            j = i + 2
//            while (true) {
//                if (j >= s.length || s[j] != '<') break
//                ansArray[j + 1] = Math.max(cur, ansArray[j + 1])
//                j++
//                cur++
//            }
//        }
//    }
//
//    println(ansArray.sum())
//}