package participated.abc152

fun main(args: Array<String>) {
    val (a,b) = readLine()!!.split(' ').map(String::toInt)

    if (a<b) {
        println(Array(b){a.toString()}.joinToString(""))
    } else {
        println(Array(a){b.toString()}.joinToString(""))
    }
}