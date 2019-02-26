
//https://atcoder.jp/contests/nikkei2019-ex/tasks/nikkei2019ex_e
fun main(args: Array<String>) {
    for (i in 1..readLine()!!.toLong()) {
        var str = ""
        if (i % 2 == 0L) str += "a"
        if (i % 3 == 0L) str += "b"
        if (i % 4 == 0L) str += "c"
        if (i % 5 == 0L) str += "d"
        if (i % 6 == 0L) str += "e"
        if (str.isEmpty()) println(i) else println(str)
    }
}
