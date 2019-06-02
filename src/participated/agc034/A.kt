package participated.agc034

fun main(args: Array<String>) {
    val input = readLine()!!.split(' ').map(String::toInt)
    val n = input[0]
    val (a, b, c, d) = input.takeLast(4).map { it }
    val s = "x" + readLine()!!

    //移動範囲内に石2連が合ったらNO
    for (i in a until c) {
        if (s[i] == '#' && s[i + 1] == '#') {
            println("No")
            return
        }
    }
    for (i in b until d) {
        if (s[i] == '#' && s[i + 1] == '#') {
            println("No")
            return
        }
    }

    //c<dの場合、先にbを動かし、後にaを動かせば必ず移動可能
    if (c < d) {
        println("Yes")
        return
    }

    //a<b<d<cの場合、bからdの間で3連で空いている場所があれば、aが飛び越えることが可能
    var canOver = false
    for (i in b..d) {
        if (s[i - 1] == '.' && s[i] == '.' && s[i + 1] == '.') {
            canOver = true
            break
        }
    }
    if (canOver) {
        println("Yes")
    } else {
        println("No")
    }
}
