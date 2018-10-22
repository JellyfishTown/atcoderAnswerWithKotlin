import java.util.*

fun main(`$`: Array<String>) {
    val v = readLine()!!
    var c = 'a'
    while (c <= 'z') {
        if (v.indexOf(c) < 0) {
            println(v + c)
            return
        }
        ++c
    }

    val set = TreeSet<Char>()
    set.add(v[v.length - 1])
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
