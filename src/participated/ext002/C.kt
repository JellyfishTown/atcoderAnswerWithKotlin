//https://aising2019.contest.atcoder.jp
package participated.ext002

var black = 0L
var white = 0L
val map = mutableListOf<MutableList<Char>>()

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(' ').map(String::toInt)
    map.add(Array(w + 2) { 'X' }.toMutableList())
    (1..h).forEach {
        val element = readLine()!!.toCharArray().toMutableList()
        element.add(0, 'X')
        element.add(element.size, 'X')
        map.add(element)
    }
    map.add(Array(w + 2) { 'X' }.toMutableList())

    var ans = 0L
    for (r in 1..h) {
        for (c in 1..w) {
            black = 0L
            white = 0L
            check(r, c)
            ans += black * white
        }
    }
    println(ans)
}

fun check(r: Int, c: Int) {
    val current = map[r][c]
    when (current) {
        'X' -> return
        '#' -> {
            black++
            map[r][c] = 'X'
        }
        '.' -> {
            white++
            map[r][c] = 'X'
        }
    }
    if (map[r - 1][c] != current) check(r - 1, c)
    if (map[r][c - 1] != current) check(r, c - 1)
    if (map[r + 1][c] != current) check(r + 1, c)
    if (map[r][c + 1] != current) check(r, c + 1)
}
