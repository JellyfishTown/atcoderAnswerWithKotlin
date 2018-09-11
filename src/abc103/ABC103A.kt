package abc103

fun main(args: Array<String>) {
    val (a1, a2, a3) = readLine()!!.split(' ').map(String::toInt)
    var min = 10000
    min = Math.min(min, Math.abs(a2 - a1) + Math.abs(a3 - a2))
    min = Math.min(min, Math.abs(a3 - a1) + Math.abs(a2 - a3))
    min = Math.min(min, Math.abs(a1 - a2) + Math.abs(a3 - a1))
    min = Math.min(min, Math.abs(a3 - a2) + Math.abs(a1 - a3))
    min = Math.min(min, Math.abs(a1 - a3) + Math.abs(a2 - a1))
    min = Math.min(min, Math.abs(a2 - a3) + Math.abs(a1 - a2))
    println(min)
}


