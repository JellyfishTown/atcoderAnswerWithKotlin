package participated.abc146

fun main(args: Array<String>) {
    val s = readLine()!!

    when(s){
        ("SUN")->println(7)
        ("MON")->println(6)
        ("TUE")->println(5)
        ("WED")->println(4)
        ("THU")->println(3)
        ("FRI")->println(2)
        ("SAT")->println(1)
    }
}