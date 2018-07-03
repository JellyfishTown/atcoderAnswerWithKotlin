fun main(args: Array<String>) {
    val s = readLine()!!

    val roma = ('a'..'z').zip(1..26).toMap()
    when {
        s == "zyxwvutsrqponmlkjihgfedcba" -> println(-1)
        s.length < 26 -> {
            val append = roma.filterKeys { s.contains(it).not() }.minBy { (key, value) -> value }!!.key
            println(s + append)
        }
        else -> for (i in 25 downTo 0) {
            if (roma[s[i - 1]]!! < roma[s[i]]!!) {
                val subs = s.subSequence(0, i).toString()
                val append = roma.filterKeys { subs.contains(it).not() }.minBy { (key, value) -> value }!!.key
                println(subs.subSequence(0, i - 1).toString() + append)
                return
            }
        }
    }
}
