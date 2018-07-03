package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val cArray = s.toCharArray()

    var max = 0
    for (i in 1..(cArray.size - 1)) {
        val countSame = countSame(cArray.slice(0..i), cArray.slice((i + 1)..(cArray.size - 1)))
        if (max < countSame) max = countSame
    }
    println(max)
}

fun countSame(ca1: List<Char>, ca2: List<Char>): Int {
    var count = 0
    for (c in 'a'..'z') {
        if (ca1.contains(c) && ca2.contains(c)) count++
    }
    return count
}