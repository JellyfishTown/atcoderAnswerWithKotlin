package point200

//参考
//https://beta.atcoder.jp/contests/abc075/submissions/2602267
fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    val s = mutableListOf<MutableList<Char>>()
    for (i in 1..h) {
        s.add(readLine()!!.toMutableList())
    }
    val d = listOf(-1 to 0, -1 to 1, 0 to 1, 1 to 1, 1 to 0, 1 to -1, 0 to -1, -1 to -1)
    for (y in 0..(h - 1)) {
        val line = mutableListOf<Char>()
        for (x in 0..(w - 1)) {
            if (s[y][x] == '#') {
                line.add('#')
                continue
            }
            var c = 0
            for ((dy, dx) in d) {
                if (y + dy !in 0..(h - 1)) {
                    continue
                }
                if (x + dx !in 0..(w - 1)) {
                    continue
                }
                if (s[y + dy][x + dx] == '#') {
                    c++
                }
            }
            line.add(c.toString().toCharArray()[0])
        }
        println(line.joinToString(separator = ""))
    }
}