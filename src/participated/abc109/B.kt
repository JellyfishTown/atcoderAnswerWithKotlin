package participated.abc109

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val wordList = mutableListOf<String>()
    wordList.add(readLine()!!)
    var before = wordList.last().last()
    for (i in 1 until n) {
        val word = readLine()!!
        val after = word.first()
        if (after != before || wordList.contains(word)) {
            println("No")
            return
        }
        wordList.add(word)
        before = word.last()
    }
    println("Yes")
}


