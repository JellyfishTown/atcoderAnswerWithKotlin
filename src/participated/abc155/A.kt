package participated.abc155

fun main(args: Array<String>) {
    val list = readLine()!!.split(' ').map(String::toLong).sorted()

    if ((list[0] == list[1] && list[0] != list[2]) || (list[2] == list[1] && list[0] != list[2])) {
        println("Yes")
    } else {
        println("No")
    }
}
