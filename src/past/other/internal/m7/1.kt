package past.other.internal.m7

fun main(args: Array<String>) {
    val s = readLine()!!
    var cur = 'N'
    for (c in s) {
        when (c) {
            'L' -> {
                when (cur) {
                    'N' -> {
                        cur = 'W'
                    }
                    'W' -> {
                        cur = 'S'
                    }
                    'S' -> {
                        cur = 'E'
                    }
                    'E' -> {
                        cur = 'N'
                    }
                }
            }
            'R' -> {
                when (cur) {
                    'N' -> {
                        cur = 'E'
                    }
                    'W' -> {
                        cur = 'N'
                    }
                    'S' -> {
                        cur = 'W'
                    }
                    'E' -> {
                        cur = 'S'
                    }
                }
            }
        }
    }
    println(cur)
}

