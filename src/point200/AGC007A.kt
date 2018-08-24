package point200

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val a = mutableListOf<CharArray>()
    for (i in 1..h) {
        a.add(readLine()!!.toCharArray())
    }

    var result = "Possible"

    for (i in 0..(h - 2)) {
        for (j in 1..(w - 1)) {
            if (a[i][j] == '#' && a[i + 1][j] == '#' && a[i + 1][j - 1] == '#') result = "Impossible"
        }
    }

    for (i in 0..(h - 2)) {
        for (j in 0..(w - 2)) {
            if (a[i][j] == '#' && a[i + 1][j] == '#' && a[i][j + 1] == '#') result = "Impossible"
        }
    }

    println(result)
}

