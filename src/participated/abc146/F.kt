package participated.abc146

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val s = readLine()!!

    val check = (1..m).joinToString("") { "1" }
    if (s.contains(check)) {
        println(-1)
        return
    }

    var cur = n
    val ansList = mutableListOf<Int>()
    while(cur!=0){
        if(cur<=m){
            ansList.add(0,cur)
            break
        }
        for(move in m downTo 1){
            val next =  cur - move
            if(s[next]=='0'){
                ansList.add(0,move)
                cur = next
                break
            }
        }
    }
    println(ansList.joinToString(" "))
}