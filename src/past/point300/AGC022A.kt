import java.util.*
fun main(args: Array<String>) {
    val v = readLine()!!
    for (c in 'a'..'z') {
        if (v.indexOf(c) < 0) {
            println(v + c)
        }
    }
    val set = TreeSet<Char>()
    set.add(v.last())

    for (i in v.length - 2 downTo 0) {
        val c = v[i]
        val h = set.higher(c)
        if (h != null) {
            println(v.substring(0, i) + h)
            return
        }
        set.add(c)
    }
    println(-1)
}

