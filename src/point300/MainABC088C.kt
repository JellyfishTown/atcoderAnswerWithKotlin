package point300

fun main(args: Array<String>) {
    val c = mutableListOf<List<Int>>()
    for (i in 1..3) {
        c.add(readLine()!!.split(" ").map(String::toInt))
    }
    val b1 = c[0][0]
    val b2 = c[0][1]
    val b3 = c[0][2]

    val a2 = c[1][0] - b1
    val a3 = c[2][0] - b1
    if ((c[1][1] == a2 + b2)
            && (c[1][2] == a2 + b3)
            && (c[2][1] == a3 + b2)
            && (c[2][2] == a3 + b3)) {
        println("Yes")
    } else {
        println("No")
    }
}
