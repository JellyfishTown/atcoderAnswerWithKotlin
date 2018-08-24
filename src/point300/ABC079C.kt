package point300

fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split("")
            .filter { it.isNotEmpty() }.map(String::toInt)
    val opList = mutableListOf<List<Int>>()
    (0..7).forEach { i ->
        run {
            opList.add(String.format("%03d", Integer.toBinaryString(i).toInt()).split("").filter { it.isNotEmpty() }.map(String::toInt))
        }
    }
    for (op in opList) {
        var result = a
        result += if (op[0] == 0) b else -b
        result += if (op[1] == 0) c else -c
        result += if (op[2] == 0) d else -d
        if (result == 7) {
            val builder = StringBuilder()
            builder.append(a)
            builder.append(if (op[0] == 0) "+" else "-")
            builder.append(b)
            builder.append(if (op[1] == 0) "+" else "-")
            builder.append(c)
            builder.append(if (op[2] == 0) "+" else "-")
            builder.append(d)
            builder.append("=7")
            println(builder.toString())
            return
        }
    }
}
