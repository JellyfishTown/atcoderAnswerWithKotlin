fun main(args: Array<String>) {
    val a = "AKIHABARA"
    val s = StringBuilder(readLine()!!)
    for (i in 0 until a.length) {
        if (a[i] != s.getOrNull(i) && a.getOrNull(i + 1) != s.getOrNull(i)) {
            println("NO")
            return
        } else if (a[i] != s.getOrNull(i) ) {
            s.insert(i, "A")
        }
    }
    if (s.length == a.length) {
        println("YES")
    } else {
        println("NO")
    }
}