package past.other.internal.m3

fun main(args: Array<String>) {
    var ans = 0
    while (true) {
        val s = readLine()!!.toCharArray()
        var x: Char? = null
        for (c in s) {
            if (c == '*') ans++
            else if (c == 'X') {
                x = c
                break
            }
        }
        if(x!=null)break
    }
    println(++ans)
}