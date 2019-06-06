import java.math.BigInteger

fun main(args: Array<String>) {
    //引数の数値を2進数表記に変換して文字配列にする
    fun toBinaryNumberCharArray(num: Long, keta: Int): CharArray {
        return String.format("%0${keta}d", java.lang.Long.toBinaryString(num).toLong()).toCharArray()
    }
    println(toBinaryNumberCharArray(65535L,16).joinToString(""))
}
