
package participated.abc136

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map(String::toLong)


    println(Math.max(c-(a-b),0))
}
