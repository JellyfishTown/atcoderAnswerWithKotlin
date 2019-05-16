import java.math.BigInteger

fun main(args: Array<String>) {
    val mod = 1000000007L
    var a = 12345678900000L
    var b = 100000L
    println(divWithMod(a,b,mod))

}

fun divWithMod(a: Long, b: Long, mod: Long): Long {
    return ((a % mod) * b.toBigInteger().modInverse(mod.toBigInteger()).toLong()) % mod
}
