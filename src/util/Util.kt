package util

//コピペ用ライブラリ


fun input() {
    val s = readLine()!!
    val n = readLine()!!.toInt()
    val l = readLine()!!.toLong()
    val (a, b) = readLine()!!.split(' ').map(String::toLong)
    val lList = readLine()!!.split(' ').map(String::toLong)

    val iGrid = mutableListOf<List<Int>>()
    for (i in 1..n) {
        iGrid.add(readLine()!!.split(' ').map(String::toInt))
    }
}

fun calcFactors(n: Int): Map<Int, Int> {//素因数分解
    val factors = mutableMapOf<Int, Int>()
    var tmp = n
    var i = 2
    while (i * i <= tmp) {
        while (tmp % i == 0) {
            factors[i] = factors.getOrElse(i) { 0 } + 1
            tmp /= i
        }
        i++
    }
    if (tmp > 1) factors[tmp] = 1
    return factors
}

//繰返二乗法
//n^p mod m を計算する
fun repeatSquaring(n: Long, p: Long, mod: Long): Long {
    if (p == 0L) return 1L
    if (p % 2 == 0L) {
        val t = repeatSquaring(n, p / 2, mod)
        return t * t % mod
    }
    return n * repeatSquaring(n, p - 1, mod)
}

// a ÷ bをmodの世界で行う
fun divWithMod(a: Long, b: Long, mod: Long): Long {
    return ((a % mod) * java.math.BigInteger.valueOf(b).modInverse(java.math.BigInteger.valueOf(mod)).toLong()) % mod
}

//切り上げ割り算
fun divWithCeil(a: Long, b: Long): Long {
    return (a + b - 1) / b
}

//引数の数値を2進数表記に変換して文字配列にする
fun toBinaryNumberCharArray(num: Long, keta: Int): CharArray {
    return String.format("%${keta}s", java.lang.Long.toBinaryString(num)).replace(" ", "0").toCharArray().reversedArray()
}

//全ての約数のリストを作成する
fun divisor(n: Long): List<Long> {
    val list = mutableListOf<Long>()
    var i = 1L
    while (i * i <= n) {
        if (n % i == 0L) {
            list.add(i)
            if (i != n / i) {
                list.add(n / i)
            }
        }
        i++
    }
    return list.sortedDescending()
}


//二分探索キュー
val queue = java.util.PriorityQueue<Long>(100, Comparator { o1: Long?, o2: Long? -> if (o1!! > o2!!) -1 else 1 })
