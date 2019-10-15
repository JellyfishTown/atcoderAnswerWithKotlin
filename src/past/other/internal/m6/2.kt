package past.other.internal.m6

//ほぼ愚直に数え上げるだけでOKだが、ループを2重にするとTLEするので多少改良する。
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val pList = (1..n).map { readLine()!!.toInt() }

    val usedNum = Array(n + 1) { false }//添字の数値が既に登場済かを保持する配列
    var totalCount = 0 //組合せの総数をカウントする変数

    for (p in pList) {
        usedNum[p] = true//p
        var pCount = 0 //pより後ろ側に存在するp×(2^i)の数値の数をカウントする
        var p2i = 2 * p //p×(2^i)
        while (p2i <= n) {
            if (usedNum[p2i].not()) pCount++//p×(2^i)が未使用であれば(=pより下側に存在する場合であれば)カウントアップ
            p2i *= 2
        }
        totalCount += pCount
    }
    println(totalCount)
}
