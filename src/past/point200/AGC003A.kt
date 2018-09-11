package past.point200

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray()
    if ((s.contains('N') && s.contains('S').not())
            || (s.contains('S') && s.contains('N').not())
            || (s.contains('E') && s.contains('W').not())
            || (s.contains('W') && s.contains('E').not())){
        println("No")
        return
    }else{
        println("Yes")
    }
}