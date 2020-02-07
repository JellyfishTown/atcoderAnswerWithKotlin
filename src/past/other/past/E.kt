package past.other.past

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(' ').map(String::toInt)
    val map = Array(n + 1) { CharArray(n + 1) { 'N' } }
    (1..q).map {
        val s = readLine()!!.split(' ')
        when (s[0]) {
            "1" -> {
                map[s[1].toInt()][s[2].toInt()] = 'Y'
            }
            "2" -> {
                val a = s[1].toInt()
                for (i in 1..n) {
                    if (map[i][a] == 'Y')
                        map[a][i] = 'Y'
                }
            }
            else -> {
                val a = s[1].toInt()
                val fl = mutableListOf<Int>()
                for (i in 1..n) {
                    if (map[a][i] == 'Y')
                        fl.add(i)
                }
                for (f in fl) {
                    for (j in 1..n) {
                        if (map[f][j] == 'Y')
                            map[a][j] = 'Y'
                    }
                }
            }
        }
    }
    (1..n).forEach { map[it][it] = 'N' }
    for (i in 1..n)
        println(map[i].takeLast(n).joinToString(""))
}
