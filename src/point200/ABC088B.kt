package point200

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map(String::toInt)
    val sortedAn = an.sortedDescending()
    val alice = sortedAn.filterIndexed { index, i -> index % 2 == 0 }
    val bob = sortedAn.filterIndexed { index, i -> index % 2 == 1 }
    println(alice.sum() - bob.sum())
}

