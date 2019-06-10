package participated.abc129
fun main(args: Array<String>) {
    val (l,a, b, m) = readLine()!!.split(' ').map(String::toLong)
    val ml = m.toString().length
    var s = ""
    for(i in l-1 downTo  0){
        s = (a + b * i).toString() + s
//        if(s.length>20)break
    }
//    if(s.length>=2* ml)s = s.takeLast(2*ml)
//    println(s.toBigDecimal().rem(m.toBigDecimal()))
    for(i in 0..6){
        println(s.takeLast(i+2) + ":"+s.takeLast(i+2).toLong()%m)
    }
}
