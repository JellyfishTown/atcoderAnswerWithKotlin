package past.point400

//なし
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val ans = mutableListOf<Char>()
    var charge = 0

    for (c in s) {
        if (charge == 0 && c == ')') {
            ans.add(0, '(')
            ans.add(')')
        }else if(c==')'){
            charge--
            ans.add(')')
        }else{
            charge++
            ans.add('(')
        }
    }
    while(charge-- > 0)ans.add(')')
    println(ans.joinToString(""))
}
